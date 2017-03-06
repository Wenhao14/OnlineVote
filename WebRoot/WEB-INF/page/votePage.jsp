<%@page import="java.math.BigDecimal"%>
<%@page import="com.olv.domain.Options"%>
<%@ page language="java" import="java.util.*,com.olv.domain.Theme"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<title>投票界面</title>
<head>
<link type="image/x-icon" href="images/favicon.ico" rel="icon">
<meta charset="utf-8" />
<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.5-dist/js/jquery-3.1.0.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="js/turn.js"></script>
<link rel="stylesheet" href="css/votePage.css" />
<link href="css/jscss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/functions.js"></script>
<link rel="stylesheet" href="iconfont/iconfont.css" type="text/css" />
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/addone.js"></script>
</head>
<body>
	<div class="top">
		<img src="images/logo.jpg" alt="" />
	</div>
	<div>
		<nav class="navbar navbar-default" role="navigation"
			style="padding: 0px; margin: 0px;">

			<span class="navbar-brand"
				style="font-family: YouYuan; padding-left:5%;">投出你宝贵的一票吧！</span>
			<div class="nav-container">

				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal"
					style="float:right ;margin-right: 5%;">
					<label
						style="font-size: 13px; padding-top:5px; padding-bottom:5px;margin: 0px;">
					          发起投票
					</label>
				</button>
		     </div>
           </nav>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="background-color:#DFF0D8">
				<div class="modal-header" style="background-color:#46B8DA;">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

					<h4 class="modal-title" id="myModalLabel">欢迎光临</h4>
				</div>
				<div>
					<div class="modal-body">
						<div class="wrap">
							<ul id="tab_t">
								<li class="act"
									style="font-family: castellar; font-size: 14px;font-family: YouYuan; background-color: #46B8DA;">登录</li>
								<li
									style="font-family: castellar; font-size: 14px; font-family: YouYuan; background-color: #46B8DA;">加入我们吧!</li>

							</ul>
							<div id="tab_c">
								<div>      
										 <input type="text" class="form-control"
											id="loginName" placeholder="请输入用户名"/>
										    <br /> <br /><br/> 
											<input
											type="password" class="form-control" id="loginPass"
											placeholder="请输入密码（六位以上）"/> 
											 <br /> <br /> 
											<span id="loginmess" style="font-size:16px;color:red;"></span>
											<br/><br/>
										<input type="button" onclick="userLogin()" class="btn btn-primary" name="login"
											value="登录" />
								</div>
								<div class="hide">
										<input type="text" class="form-control" id="regName"
											placeholder="请输入用户名"> <img
											style="width: 30px; height: 30px; float: right;margin-top: -32px;"
											src="" alt="" /> <br />
										<input type="text" class="form-control" id="regAddress"
											placeholder="请输入地址"> <img
											style="width: 30px; height: 30px; float: right;margin-top: -32px;"
											src="" alt="" /> <br /> <input type="password"
											class="form-control" id="regPass1"
											placeholder="请输入密码（六位以上）"> <img
											style="width: 30px; height: 30px; float: right;margin-top: -32px;"
											src="" alt="" /> <br /> <input type="password"
											class="form-control" id="regPass2"
											placeholder="请确认密码（六位以上）"> <br /> <img
											style="width: 30px; height: 30px; float: right;margin-top: -45px;"
											src="" alt="" /> 
											<span id="regmess" style="font-size:16px;color:red;"></span>
											<br/><br/>
										<input type="button" onclick="userRegster()" class="btn btn-primary"
											value="立即注册" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	     Theme theme=(Theme)request.getAttribute("theme");
		  Set<Object>  set = theme.getOptionses();
		  Iterator<Object> it =set.iterator();
		  int voteSum=(int)request.getAttribute("voteSum");
	 %>
	<div class="Header">
		<span class="statictxt">投票主题：</span> <span class="mainidea"><%=theme.getDetails() %></span>
		<div>
			<label for="name" style="font-size: 18px; margin-top: 10px;">已投票人数<span
				class="personnumber"><b id=voteSum><%=voteSum %></b>！</span>
			</label>
		</div>

	</div>
	<div class="imgchart">

		<table class="chart" >
			<tr>
				<td><div>
						<img  id ="piechart" class="left-chart" src="images/pie3DChart.jpg" />
					</div></td>
				<td><div>
						<img id = "barchart" class="right-chart" src="images/bar3DChart.jpg" />
					</div></td>
			</tr>
		</table>
	</div>
	<div>
			<div class="main">
				<table class="table table-striped">
					<thead>
						<tr style=" margin-top: 20px auto;">
							<th>选项</th>
							<th>详情介绍</th>

						</tr>
					</thead>
					<tbody >
					     <%
					        if(theme.getType()==1){
				                 while(it.hasNext()){
				                     Options options=(Options)it.next();
									   %>
												<tr>
													<td>
														<div
															style="text-align: center;padding-top: 40%; padding: 40%;font-family: YouYuan;font-size: 20px;">
															<span><b><%=options.getDetails() %></b></span>
														</div>
														<div id="<%=options.getOid()%>" class="opera" style="height: 60%;">
							
															<span id="btn" onclick="chang(<%=options.getOid()%>,<%=theme.getTid() %>)"> <i class="iconfont">&#xe602;</i>投票
															</span> <span class="glyphicon glyphicon-user"
																style="float: right; background-color: #14A5EB;width:95px;height:36px;padding-top: 5px;margin-top: -37px;">
																<b><%=options.getVotes().size() %></b>票</span>
														</div>
													</td>
													<td><span class="introduce"><%=options.getIntroduction() %></span></td>
												</tr>
					                  <%
							}
							} else {
								while (it.hasNext()) {
									Options options = (Options) it.next();
						                %>
											<tr>
												<td>
													<div>
														<a href=""><img src="<%=options.getDetails() %>"
															style="width:200px;height: 200px;" /></a>
													</div>
													<div>
														<div id="<%=options.getOid()%>" class="opera">
						
															<span id="btn" onclick="chang(<%=options.getOid()%>)"> <i class="iconfont">&#xe602;</i> 投票
															</span> <span class="glyphicon glyphicon-user"
																style="float: right; background-color: #14A5EB;width:95px;height:36px;padding-top: 5px;margin-top: -37px;">
																<b><%=options.getVotes().size() %></b>票</span>
						
														</div>
													</div>
												</td>
												<td><span class="introduce"><%=options.getIntroduction() %></span></td>
											</tr>

						              <%
							    }
							}
						%>
						
					</tbody>
				</table>
			</div>

	</div>
	<hr />
	<div class="bottom-left" style="background-color:#045791; ">
		<p>
		<div style="padding-top: 15px; ">
			<img src="images/logo.png"
				style="width: 50px; height: 45px; margin-left: 35%;" /> <a
				style="text-align: center;font-size: 17px; color: white;">@西安科技大学
				计算机学院&蓝桥学院</a>
		</div>
		<p id="back-to-top" style="display: block;">
			<a href="#top"><span></span>回到顶部</a>
		</p>

	</div>
</body>
</html>
