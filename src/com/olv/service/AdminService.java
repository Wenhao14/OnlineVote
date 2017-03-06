package com.olv.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.olv.domain.Theme;
import com.olv.domain.Users;

public class AdminService {
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
	 * 同意主题发布
	 */
	@Transactional
	public void alterThemeState(Theme theme){
		try {
			Theme t=(Theme) sessionFactory.getCurrentSession().load(Theme.class, theme.getTid());
		    t.setState("是");
		    sessionFactory.getCurrentSession().update(t);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	/*
	 * 提取所有未通过的主题
	 */
	@Transactional
	public List<Theme> getAllNoTheme(){
		String sql="from Theme theme where theme.state='否'";
		@SuppressWarnings("unchecked")
		List<Theme> list = (List<Theme>) sessionFactory.getCurrentSession().createQuery(sql).list();
	    return list;
	}
	/*
	 * 删除主题
	 */
	@Transactional
	public void deleteTheme(Theme theme){
		
		try {
			sessionFactory.getCurrentSession().delete(theme);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
     
}
