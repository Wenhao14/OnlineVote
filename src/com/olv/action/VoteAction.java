package com.olv.action;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.olv.domain.Address;
import com.olv.domain.Options;
import com.olv.domain.Theme;
import com.olv.domain.Vote;
import com.olv.service.ChartService;
import com.olv.service.VoteService;
import com.opensymphony.xwork2.ActionSupport;

public class VoteAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VoteService  voteService;
	private HttpServletRequest request;
	private Theme theme;
	private String message;
	private ChartService chartService;
	
	/*
	 * ajax返回结果
	 */
	public String getMessage() {
		return message;
	}
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	public void setChartService(ChartService chartService) {
		this.chartService = chartService;
	}
  /*
   * 添加投票
   */
	public String addVote(){
		try {
			String oid=request.getParameter("oid");
			int aid=(int) (Math.random()*1000)%8+1;
			Vote vote=new Vote();
			Options options=new Options();
			options.setOid(new BigDecimal(oid));
			vote.setOptions(options);
			Address address=new Address();
			address.setAid(new BigDecimal(aid));
			vote.setAddress(address);
			vote.setOptions(options);
			voteService.addVote(vote);
			message="1";
		//	Theme theme=new Theme();
			//theme.setTid(new BigDecimal(request.getParameter("tid")));
		//	Theme t=voteService.getSelectTheme(theme);
			//chartService.getVoteChart(t);
			//chartService.getAddressChart(t);
			return "addVoteSuccess";
		} catch (Exception e) {
			message="0";
			return "addVoteFail" ;
		}
	}
	
	/*
	 * 提取主题
	 */
	public String getAllTheme(){
		try {
			List<Theme> list=voteService.getAllTheme();
			request.setAttribute("themes",list);
			return "getThemeSuccess";
		} catch (Exception e) {
			return "getThemeFail";
		}
		
	}
	/*
	 * 提取将要投票的主题
	 */
	public String getSelectTheme(){
		try {
			theme=new Theme();
			theme.setTid(new BigDecimal(request.getParameter("Tid")));
			Theme t=voteService.getSelectTheme(theme);
			chartService.getVoteChart(t);//刷新图表
			chartService.getAddressChart(t);
			Set<Object>  set = t.getOptionses();
			Iterator<Object> it =set.iterator();
			int voteSum=0;
			while(it.hasNext()){
			       Options o=(Options)it.next();
			       voteSum+=o.getVotes().size();
			  }
			request.setAttribute("voteSum", voteSum);
			request.setAttribute("theme", t);
		  
			return "getSuccess";
		} catch (Exception e) {
			return "getFail";
		}	
	}
	/*
	 *获取request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;	
	}

}
