package com.olv.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.olv.domain.Theme;
import com.olv.domain.Users;
import com.olv.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private Users user;
	private Theme theme;
	private String message;
	private HttpServletRequest request;
	 /*
	  *  注入userService
	  */
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
    /*
     * ajax返回数据
     */
    public String getMessage() {
		return message;
	}
    /*
     * 跳转页面
     * 
     */
    public String dump(){
    	return "dump";
    }
	/*
     * 会员员验证
     */
	public String userLogn(){
		user=new Users();
		user.setUsername(request.getParameter("userName"));
		user.setPassword(request.getParameter("passWord"));
		user.setGrade((byte)2);
	    int result=	userService.userLogn(user);
		if(result==1){
		    //验证成功	
			//转换页面
			message="1";
			return "uLognSuccess";
		}else if(result==0){
			//密码错误
			message="0";
			return "uLognFail";
		}else{
			//用户不存在
			message= "-1";
			return "uLognFail";
		}
    }
	/*
	 * 发起主题
	 */
	 public String  addTheme(){
		try {
		    theme=new Theme();
		    theme.setDetails(request.getParameter(""));
		   // theme.setLasttime(request.getParameter(""));
		    theme.setState(request.getParameter(""));
		   // theme.setType(request.getParameter(""));
		    //theme.setUsers(new Users().setUserid(new BigDecimal(request.getParameter(""))));
		    userService.addTheme(theme);
		    //成功
		    message="1";
		    return "addThemeSuccess";
		} catch (Exception e) {
			//失败
			message="0";
			return "addThemeFail";
		}
		 
	 }
	 /*
	  * 会员注册
	  * 
	  */
	 public  String  addUser(){
		 try {
			Users user=new Users();
			user.setUsername(request.getParameter("regName"));
			user.setPassword(request.getParameter("regPass1"));
			user.setTean(request.getParameter("regAddress"));
			user.setGrade((byte)2);
		    userService.addUser(user);
		    message="1";
		    return "addUserSuccess";
		} catch (Exception e) {
			message="0";
			return "addUserFail";
		}
		    
	 }
	@Override
	public void setServletRequest(HttpServletRequest request) {
		 this.request=request;
		
	}
}
