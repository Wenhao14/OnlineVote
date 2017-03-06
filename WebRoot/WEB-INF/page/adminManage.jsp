<%@page import="com.olv.domain.Options"%>
<%@ page language="java" import="java.util.*,com.olv.domain.Theme" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<title>管理员界面</title>
<head>
<meta charset="utf-8" />
<link type="image/x-icon" href="images/favicon.ico" rel="icon">
<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.5-dist/js/jquery-3.1.0.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="js/managePage.js"></script>
<script type="text/javascript" src="js/functions.js"></script>
<link rel="stylesheet" href="css/managePage.css" />
<script src="js/float.js"></script>
</head>
<body>
	<div class="">
		<img src="images/logo.jpg" alt="" style="width: 100%;height: 250px;" />
	</div>
	<div>
		<div>
			<p
				style="text-align: center; margin-top: 2%; font-family: YouYuan;font-size: 17px;">欢迎管理员登录！</p>
		</div>
		<div class="panel-group"">
			<div class="panel panel-primary">
				<div class="panel-heading">选项列表</div>
				<div class="panel-body">
					<div class="check">
						<div id="button">
							<br /> <a href="#" onclick="change_div('ondetermine')"
								style=" font-family: YouYuan;font-size: 20px;">待审核</a> <br />
						</div>
						<div>
							<div id="ondetermine">
                                  
								<table class="table table-bordered table-hover">
									<thead>
										<tr class="success">
											<th>选项名称</th>
											<th>截止时间</th>
											<th>发起单位</th>
											<th></th>

										</tr>
									</thead>
									<tbody>
									
			                       <%
									    List<Theme> list=(List<Theme>)request.getAttribute("noList");
									    String [] color={"#F5F5F5","#DFF0D8","#FCF8E3","#F2DEDE"};
									     for(int i=0;i<list.size();i++){
	                                               Theme theme=list.get(i);
	                                               Set<Object>  set = theme.getOptionses();
                                                   Iterator<Object> it =set.iterator();
	                                        if(theme.getType()==1){
	                                             %>
	                                          
	                                                <tr id=<%=theme.getTid() %>>
													<td><a onmouseover="MM_over(this)"
														onmouseout="MM_out(this)"><%=theme.getDetails() %>
															<ul style="display:none;">
									
																<div style="position: absolute;background-color: #87CEEB;">
																	<span>
																		<table>
																		       <%
																		           while(it.hasNext()){ 
																		               Options options=(Options)it.next();
																		               %>
																		                    <tr>
																								<td>
																									<div
																										style="text-align: center;padding-top: 40%; padding: 40%;font-family: YouYuan;font-size: 20px;">
																										<span><b><%=options.getDetails() %></b></span>
																									</div>
							
																									<div></div>
																									</div>
																								</td>
																								<td><span class="introduce"><%=options.getIntroduction() %></span></td>
																							</tr>
																		           
																		               <%
																		           }
																		        %>
																			
																		</table>
																	</span>
			
																</div>
															</ul>
													</a></td>
			
													<td><%=theme.getLasttime() %></td>
													<td><%=theme.getUsers().getTean() %></td>
													<td>
														<div>
															<button onclick="delet(<%=theme.getTid() %>)" class="btn btn-primary" >删除</button>
															<button onclick="throuth(<%=theme.getTid() %>)" class="btn btn-primary" >通过</button>
														</div>
													</td>
													</tr> 
	                    
	                                             <%  
	                          
	                                        }else{
	                                             %>
	                                                <tr id=<%=theme.getTid() %>>
													<td><a onmouseover="MM_over(this)"
														onmouseout="MM_out(this)"><%=theme.getDetails() %>
															<ul style="display:none;">
									
																<div style="position: absolute;background-color: #87CEEB;">
																	<span>
																		<table>
																		       <%
																		           while(it.hasNext()){ 
																		               Options options=(Options)it.next();
																		               %>
																		                    <tr>
																								<td>
																									<div>
																										<a href=""><img src="<%=options.getDetails() %>"
																											style="width:200px;height: 200px;" /></a>
																									</div>
							
																									<div></div>
																									</div>
																								</td>
																								<td><span class="introduce"><%=options.getIntroduction() %></span></td>
																							</tr>
																		           
																		               <%
																		           }
																		        %>
																			
																		</table>
																	</span>
			
																</div>
															</ul>
													</a></td>
			
													<td><%=theme.getLasttime() %></td>
													<td><%=theme.getUsers().getTean() %></td>
													<td>
														<div>
															<button onclick="delet(<%=theme.getTid() %>)" class="btn btn-primary" value="删除">删除</button>
															<button onclick="throuth(<%=theme.getTid() %>)" class="btn btn-primary" value="通过">通过</button>
														</div>
													</td>
													</tr> 
	                                        
	                                             <%
	                                        }
                       
	                                     }
									 %>
									</tbody>
								</table>

							</div>

						</div>
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</div>
	<hr style=" padding: 0px; margin: 0px;" />
	<div class="bottom-left" style="background-color:#045791; ">
		<p>
		<div style="padding-top: 15px; ">
			<img src="images/logo.png"
				style="width: 50px; height: 45px; margin-left: 35%;" /> <a
				style="text-align: center;font-size: 17px; color: white;">@西安科技大学
				计算机学院&蓝桥学院</a>
		</div>
		<a href="#">回顶部</a>
	</div>
</body>
</html>

