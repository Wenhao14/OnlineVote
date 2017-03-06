<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link type="image/x-icon" href="images/favicon.ico" rel="icon">
<title>出错了</title>
<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.5-dist/js/jquery-3.1.0.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="js/jump.js"></script>
<style type="text/css">
	html{
		height: 980px;
	}
	.container{
		
		height: 980px;
	}
</style>
</head>
<body>
<div class="jumbotron">
  <div class="container">
    <p>额额，出错了，<span id="jumpTo">5</span>秒后自动跳转到系统首页！
<script type="text/javascript">
countDown(5,'index.jsp');
</script></p>
     <p><a href="index.html">
         若未自动跳转，请点击此处！</a>
    </p>
  </div>
</div>
 </body>
</html>
