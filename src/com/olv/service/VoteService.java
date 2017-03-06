package com.olv.service;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.olv.domain.Theme;
import com.olv.domain.Vote;

public class VoteService {
    private SessionFactory sessionFactory;
    /*
     * 注入SessionFactory
     */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * 添加投票
	 */
	@Transactional
	public void addVote(Vote vote){
		try {
			String sql="{Call invote(?,?)}";     
		    sessionFactory.getCurrentSession().createSQLQuery(sql).setBigDecimal(0, vote.getOptions().getOid()).setBigDecimal(1,vote.getAddress().getAid()).executeUpdate();
		} catch (Exception e) {
		}
		
	}
	/*
	 * 提取所有主题
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Theme> getAllTheme(){
		String sql="from Theme theme where theme.state='是'";
		List<Theme> list = (List<Theme>) sessionFactory.getCurrentSession().createQuery(sql).list();
	    return list;
	}
    /*
     * 提取某个主题
     */
	@Transactional
	public Theme  getSelectTheme(Theme t){
		Theme theme=(Theme) sessionFactory.getCurrentSession().load(Theme.class,t.getTid());
		return theme; 
	}
	/*
	 * 提取搜索的主题
	 */
	@Transactional
	public List<Theme> getSearchTheme(String requ ){
		String sql="from Theme theme where theme.details like '%?%";
		@SuppressWarnings("unchecked")
		List<Theme> list = (List<Theme>) sessionFactory.getCurrentSession().createQuery(sql).setString(0, requ);
	    return list;
	}
	/*
	 * 提取投票地区分布
	 * 
	 */
	@Transactional
	public List<Object> getAddressVoteSum(Theme theme) {
		try {
			String sql="SELECT sum, name FROM ( SELECT COUNT(*) sum , vote.aid aid From Vote vote  WHERE vote.oid IN(SELECT options.oid FROM Options  options WHERE options.tid=? ) GROUP BY  vote.aid ) addr, "
					+" Address address WHERE addr.aid=address.aid AND addr.sum>0";
			@SuppressWarnings("unchecked")
			List<Object> list=sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter(0,theme.getTid()).list();
			return list;
		} catch (Exception e) {
			return null;
		}   
	}
    
}
