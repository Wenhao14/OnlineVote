package com.olv.action;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.olv.domain.Theme;
import com.olv.domain.Users;
import com.olv.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * �û��Ϸ�����֤
	 */
	private AdminService adminService;
	
	private Users user;
	
	private String message;
	HttpServletRequest request;
	
	public String getMessage() {
		return message;
	}
	
    public void setMessage(String message) {
		this.message = message;
	}

	/*
     * ע��adminService
     */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
    /*
     * ����Ա�Ϸ�����֤
     */
	public String adminLogn(){
		user=new Users();
		user.setUsername(request.getParameter("userName"));
		user.setPassword(request.getParameter("passWord"));
		user.setGrade((byte)1);
	    int result=	adminService.userLogn(user);
	    System.out.println(result);
		if(result==1){
		    //��֤�ɹ�	
			message="1";
			return "aLognSuccess";
		}else if(result==0){
			//�������
			message="0";
			return "aLognFail";
		}else{
			//�û�������
			message= "-1";
			return "aLognFail";
		}
    }
	/*
	 * �������Ϸ���
	 */
	public String alterState(){
   		try {
   			Theme theme=new Theme();
   			theme.setTid(new BigDecimal(request.getParameter("tid")));
			adminService.alterThemeState(theme);
			message="1";
			return "alterSuccess";
		} catch (Exception e) {
             message="0";
             return "alterFail";
		}
		
	}
	/*
	 * ��ȡ����δͨ������
	 * 
	 */
	public String getNoTheme(){
		try {
			List<Theme> list=	adminService.getAllNoTheme();
			request.setAttribute("noList",list);
			System.out.println(list.size());
		    return "getNoSuccess";
		} catch (Exception e) {
			return "getNoFail";
		}
	}
	/*
	 * 
	 * ɾ������
	 */
	public String deleteTheme(){
		try {
			Theme theme=new Theme();
			theme.setTid(new BigDecimal(request.getParameter("tid")));
			adminService.deleteTheme(theme);
			message="1";
			return "deleteSuccess";
		} catch (Exception e) {
			message="0";
			return "deleteFail";
		}
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request=request;
		
	}
	
}
