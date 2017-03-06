<%@ page language="java" import="java.util.*,com.olv.domain.Theme" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="image/x-icon" href="images/favicon.ico" rel="icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录</title>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/loginPage.css"/>
<script src="bootstrap-3.3.5-dist/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/functions.js"></script>
</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>后台管理登录</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="adminName" class="form-control" placeholder="用户名" size="30">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="adminPass" class="form-control" placeholder="密码" size="30">
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<button type="submit" onclick="adminLogin()" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</button>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-6 link">
						<p class="text-center remove-margin">
						</p>
					</div>
					<div class="col-xs-6 link">
						<p class="text-center remove-margin">
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div style="text-align:center;">
<p></p>
</div>

</body>

</html>