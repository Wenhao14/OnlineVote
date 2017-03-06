package com.olv.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.olv.domain.Theme;
import com.olv.domain.Users;

public class UserService {
    private SessionFactory sessionFactory;
    /*
     * 注入sessionFactory
     */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * 用户合法性验证
	 */
	@Transactional
	public int userLogn(Users user){
		String sql="from Users user where user.username=?";
		try {
			@SuppressWarnings("unchecked")
			List<Users> list=(List<Users>)sessionFactory.getCurrentSession().createQuery(sql).setString(0, user.getUsername()).list();
		    if(list!=null){
		    	Users u=list.get(0);
				if(u.getGrade()==user.getGrade()){
					if(u.getPassword().equals(user.getPassword())){
						return 1;//登录成功
					}else{
						return 0;//密码错误
					}
				}else{
					return -1;//用户不存在
				}
				
			}else{
			  return -1;//用户不存在	
			}
		} catch (Exception e) {
			return -1;
		}
		
	}
	/*
	 * 添加投票主题
	 */
	@Transactional
	public void addTheme(Theme theme){
		String sql="{call intheme(?,?,?,?,?)}";
		sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter(0, theme.getDetails()).setParameter(1, theme.getLasttime()).setParameter(2, theme.getState()).setParameter(3, theme.getType()).setParameter(4, theme.getUsers().getUserid()).executeUpdate();
	}
     /*
      * 用户注册
      */
	@Transactional
	public void addUser(Users user){
		String sql="{call inuser(?,?,?,?)}";
		int i=sessionFactory.getCurrentSession().createSQLQuery(sql).setByte(0, user.getGrade()).setString(1, user.getUsername()).setString(2, user.getPassword()).setString(3, user.getTean()).executeUpdate();	
	    System.out.println(i);
	}
}
