package com.olv.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.olv.domain.Theme;
import com.olv.domain.Users;

public class UserService {
    private SessionFactory sessionFactory;
    /*
     * ע��sessionFactory
     */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * �û��Ϸ�����֤
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
						return 1;//��¼�ɹ�
					}else{
						return 0;//�������
					}
				}else{
					return -1;//�û�������
				}
				
			}else{
			  return -1;//�û�������	
			}
		} catch (Exception e) {
			return -1;
		}
		
	}
	/*
	 * ���ͶƱ����
	 */
	@Transactional
	public void addTheme(Theme theme){
		String sql="{call intheme(?,?,?,?,?)}";
		sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter(0, theme.getDetails()).setParameter(1, theme.getLasttime()).setParameter(2, theme.getState()).setParameter(3, theme.getType()).setParameter(4, theme.getUsers().getUserid()).executeUpdate();
	}
     /*
      * �û�ע��
      */
	@Transactional
	public void addUser(Users user){
		String sql="{call inuser(?,?,?,?)}";
		int i=sessionFactory.getCurrentSession().createSQLQuery(sql).setByte(0, user.getGrade()).setString(1, user.getUsername()).setString(2, user.getPassword()).setString(3, user.getTean()).executeUpdate();	
	    System.out.println(i);
	}
}
