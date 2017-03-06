function userLogin(){
	var userName=$("#loginName").val();
	var passWord=$("#loginPass").val();
	$.ajax({
		url:"usersAction!userLogn.do",
		type: "post",
		dataType:"json",
		data:{
			"userName":userName,
			"passWord":passWord,
			"action":new Date().getTime()
		},
		success : function(data){
			if(data==1){
				  window.location.href="usersAction!dump.do";
				}else if(data==0){
					$("#loginmess").text("*密码错误");
				}else{
					$("#loginmess").text("*用户名不存在");
				}
		},
		error:function(){
			alter("服务器异常,请稍后再试");
		}
	});
}
function adminLogin(){
	
	var userName=$("#adminName").val();
	var passWord=$("#adminPass").val();
	$.ajax({
		url:"adminAction!adminLogn.do",
		type: "post",
		dataType:"json",
		data:{
			"userName":userName,
			"passWord":passWord,
			"nocache":new Date().getTime()
		},
		success : function(data){
			if(data==1){
			  window.location.href="adminAction!getNoTheme.do";
			}else if(data==0){
				alert("密码错误");
			}else{
				alert("用户名不存在");
			}
		},
		error:function(){
			alter("服务器异常,请稍后再试");
		}
	});
}
function userRegster(){
	var regName=$("#regName").val();
	var regAddress=$("#regAddress").val();
	var regPass1=$("#regPass1").val();
	var regPass2=$("#regPass2").val();
	$.ajax({
		url:"usersAction!addUser.do",
		type: "post",
		dataType:"json",
		data:{
			"regName":regName,
			"regPass1":regPass1,
			"regAddress":regAddress,
			"action":new Date().getTime()
		},
		success : function(data){
			if(data==1){
				$("#regmess").text("恭喜！注册成功");
			}else{   
				$("#regmess").text("注册失败");
			}
		}
	});
}
function throuth (tid){
	$.ajax({
		url:"adminAction!alterState.do",
		type: "post",
		dataType:"json",
		data:{
			"tid":tid,
			"action":new Date().getTime()
		},
		success : function(data){
			if(data==1){
				//成功
				$("#"+tid).remove();
			}else{   
				//失败
				alert("修改失败");
			}
		}
	});
}
function delet(tid){
	$.ajax({
		url:"adminAction!deleteTheme.do",
		type: "post",
		dataType:"json",
		data:{
			"tid":tid,
			"action":new Date().getTime()
		},
		success : function(data){
			if(data==1){
				//成功
				$("#"+tid).remove();
			}else{   
				//失败
				alert("删除失败");
			}
		}
	});
}
