<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <link rel="stylesheet" href="css/managePage.css" />
    <script src="js/float.js"></script>
    <script src="js/textliebiao.js"></script>
    <script type="text/javascript" src="js/datetime.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.date_input.pack.js"></script> 
<link href="css/datePicker.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript">
$(function(){
	$('#datePicker').date_input();
	$('#datePicker2').date_input();
	})
</script>
<style>
</style>
</head>  
<body>
	<div class="">
<img src="images/logo.jpg" alt="" style="width: 100%;height: 240px;"/>
</div>
<div>
	<div><p style="text-align: center; margin-top: 2%; font-family: YouYuan;font-size: 17px;">欢迎创建有趣的投票！</p></div>
<div class="panel-group"">  
            <div class="panel panel-primary">  
                <div class="panel-heading">  
                               创建投票
                </div>  
                <div class="panel-body" style="background-color: #E1F2FE;">  
            <div class="check">
  <div id="button">
  	<br	 />
   
      <a href="#" onclick="change_div('ondetermine')" style=" font-family: YouYuan;font-size: 20px;">第一步</a>
     
      <a href="#" onclick="change_div('finish'),dianwoa()"  style="font-family: YouYuan;font-size: 20px" >第二步</a>
    
    
    
    
    <br />
  </div>
  <div>
  <div id="ondetermine">
    <div class="">
    <table style="margin-left: 20%;;">
       <tr>    	
       	<td ><big>投票主题：</big></td>
       	<td><input type="text" class="form-control" placeholder="投票主题">
       	</td>
       </tr>
       <tr>
       	<td><big >可选项个数：</big></td>
       	<td><input type="number" class="num" id="txt"/></td>
       </tr>
       <tr>
       	<td><big >投票类型：</big>  	    	
    </td>
       	<td><select class="select"  id="wztp" >
    		<option value ="null">--请选择--</option>
    		<option value="0" >文字 </option>
    		<option value="1" >图片 </option>
    	</select></td>
       </tr>
       <tr>
       	<td><big >到期时间：</big></td>

       	<td><center>
       		<input type="text" id="datePicker" class="date_picker" placeholder="点击选择日期"/>
       		</center></td>
       	<td></td>
       </tr>
    	
    	
      
    
    	
    
    </table>
     <a href="#" onclick="check()"><input class="btn btn-primary" type="button" value="确认"/></a>
     <a href="#" onclick="change_div('finish'),dianwoa()"><input class="btn btn-primary" type="button" value="下一步" id="tijiao"/></a>
  	</div>
   
   

    </div>
   
  </div>
  
  <div id="finish" >

    <div class="">
   <div class="secondtheme">
    	<b class="zhutiziti" >你的主题：</b>
    </div>
<a href="" onclick="change_div('ondetermine')"><input class="btn btn-primary" type="button" value="上一步" /></a>



    </div>
  </div>
 </div>
 </div>
<div class="panel-footer">  
  <a href="#" onclick="change_div('finish'),dianwoa()"><input class="btn btn-primary" type="button" value="提交" /></a>                
                    </div>   
        </div>
</div>
</div>
</div>
<hr  style=" padding: 0px; margin: 0px;" />
<div class="bottom-left" style="background-color:#045791; ">
<p>
	<div style="padding-top: 15px; ">
	<img src="images/logo.png" style="width: 50px; height: 45px; margin-left: 35%;" />		
	<a style="text-align: center;font-size: 17px; color: white;">@西安科技大学 计算机学院&蓝桥学院</a>
    </div>
    <a href="#">回顶部</a>	
</div>
</body>  
</html> 

