<%@ page language="java" import="java.util.*,com.olv.domain.Theme" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<title>首页</title>
<head>
<meta charset="utf-8" />
<link type="image/x-icon" href="images/favicon.ico" rel="icon">
<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.5-dist/js/jquery-3.1.0.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="js/turn.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/roundabout.js"></script>
<script type="text/javascript" src="js/roundshapes.js"></script>
<link href="css/jscss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/functions.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('#myRoundabout').roundabout({
			shape : 'figure8',
			minOpacity : 1,
			btnNext : '#bt-next',
			btnPrev : '#bt-previous'
		});
	});	
</script>
<link rel="stylesheet" href="css/round.css" />
<link rel="stylesheet" href="css/homePage.css" />
<style>
.form-control {
	width: 200px;
}
</style>
</head>
<body>
	<div class="logo">
		<img src="images/logo.jpg" alt="log" />
	</div>

	<div>
		<nav class="navbar navbar-default" role="navigation" style="padding: 0px; margin: 0px;">

			<span class="navbar-brand" style="font-family:YouYuan;padding-left:5%;">参与投票，说出心声！</span>
			<div class="nav-container">

				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal" style="float: right; margin-right:5%;">
					<label
						style="font-size: 13px; padding-top:5px; padding-bottom:5px;margin: 0px;">发起投票</label>
				</button>
				<div class="search-box" style="padding-right: 15%;">
					<form class="navbar-form navbar-right hidden-xs" role="search">

						<div class="form-group has-feedback">
							<input type="text" class="form-control" placeholder="Search">
							<span class="glyphicon glyphicon-search form-control-feedback"></span>
						</div>
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>

				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content" style="background-color:#DFF0D8">
							<div class="modal-header" style="background-color:#46B8DA;">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>

								<h4 class="modal-title" id="myModalLabel">欢迎登录</h4>
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
			</div>
	</div>
	<div>
		<div class="wrap_it_all">
			<div class="center">
				<div class="grad_main"></div>
				<div class="wrapper">
					<ul id="myRoundabout" class="roundabout-holder"
						style="padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; position: relative; z-index: 100; ">
						<li id="ch_0" class="roundabout-moveable-item"
							style="position: absolute; left: 504.3px; top: 68.8px;  opacity: 1; z-index: 296; font-size: 9.51px; "
							current-scale="0.7927"><a href="#"><img
								class="alignnone size-full wp-image-35" title="slide5"
								src="images/turn5.jpg" alt="" width="433" height="306">
							<p></p></a></li>
						<li id="ch_1" class="roundabout-moveable-item roundabout-in-focus"
							style="position: absolute; left: 224.1px; top: 35px;  opacity: 1; z-index: 400; font-size: 12px; "
							current-scale="1.0000"><a href="#"><img
								class="alignnone size-full wp-image-33" title="slide4"
								src="images/turn2.jpg" alt="" width="433" height="306"></a></li>
						<li id="ch_2" class="roundabout-moveable-item"
							style="position: absolute; left: 33.5px; top: 68.8px; opacity: 1; z-index: 296; font-size: 9.51px; "
							current-scale="0.7927"><a href="#"><img
								class="alignnone size-full wp-image-31" title="slide3"
								src="images/turn3.jpg" alt="" width="433" height="306"></a></li>
						<li id="ch_3" class="roundabout-moveable-item"
							style="position: absolute; left: 722.4px; top: 123.5px; opacity: 1; z-index: 129; font-size: 5.49px; "
							current-scale="0.4573"><a href="#"><img
								class="alignnone size-full wp-image-29" title="slide2"
								src="images/turn4.jpg" alt="" width="433" height="306"></a></li>
						<li id="ch_4" class="roundabout-moveable-item"
							style="position: absolute; left: -39.4px; top: 123.5px;  opacity: 1; z-index: 129; font-size: 5.49px; "
							current-scale="0.4573"><a href="#"><img
								class="alignnone size-full wp-image-27" title="slide1"
								src="images/turn1.jpg" alt="" width="433" height="306"></a></li>
					</ul>
					<div class="round_conrol">
						<div id="bt-next"></div>
						<div id="bt-previous"></div>
					</div>

				</div>
			</div>
			<div style="text-align:center;"></div>
		</div>

		<div class="maintable">

			<form class="form">
				<div class="panel panel-primary">

					<div>
						<h2>
							<span class="label label-default" style="margin-left:43%;background-color:#2E7EC6;">待投票主题</span>
						</h2>
					</div>
					<div class="tableform">
						<table class="table">
							<caption></caption>
							<thead>
								<tr>
									<th>主题</th>
									<th>到期日期</th>
                                    <th>发起单位</th>
									<th>投票</th>
								</tr>
							</thead>
							<%
							    List<Theme> list=(List<Theme>)request.getAttribute("themes");
							    String [] color={"#F5F5F5","#DFF0D8","#FCF8E3","#F2DEDE"};
							 %>
							<tbody>
							  <%
							      for(int i=0;i<list.size();i++){
							           Theme theme=list.get(i);
							      %>
							      
							       <tr style="background: <%=color[i%color.length] %>" >
										<td><%=theme.getDetails() %></td>
										<td><%=theme.getLasttime() %></td>
	                                    <td><%=theme.getUsers().getTean() %></td>
										<td>
										     <a href="voteAction!getSelectTheme.do?Tid=<%=theme.getTid()%>">
										     <img src="images/govote.png"  style="width: 40px;height: 30px;"/>
										     </a>
										</td>
									</tr>
							      <%
							      }
							  %>
								
							</tbody>
						</table>
					</div>
				</div>
			</form>
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
			<p id="back-to-top" style="display: block;"><a href="#top"><span></span>回到顶部</a></p>
		</div>
</body>
</html>
