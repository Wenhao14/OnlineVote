package com.olv.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.olv.domain.Theme;
import com.olv.domain.Users;

public class AdminService {
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
	 * ͬ�����ⷢ��
	 */
	@Transactional
	public void alterThemeState(Theme theme){
		try {
			Theme t=(Theme) sessionFactory.getCurrentSession().load(Theme.class, theme.getTid());
		    t.setState("��");
		    sessionFactory.getCurrentSession().update(t);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	/*
	 * ��ȡ����δͨ��������
	 */
	@Transactional
	public List<Theme> getAllNoTheme(){
		String sql="from Theme theme where theme.state='��'";
		@SuppressWarnings("unchecked")
		List<Theme> list = (List<Theme>) sessionFactory.getCurrentSession().createQuery(sql).list();
	    return list;
	}
	/*
	 * ɾ������
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
