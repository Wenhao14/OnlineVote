
function check(){
	if(document.getElementById("txt").value<=0)
	{
		alert("请输入大于零的正整数");
		return;
	}
	if(document.getElementById("text1").value=="")
	alert("主题不能为空");
	
	if(document.getElementById("wztp").value==0)
	alert("请选择文字或图片");
}

function  dianwoa(){
	  
	var sel = document.getElementById("wztp").value;
		if(sel==0){
for(var i=0;i<document.getElementById("txt").value;i++){
	var str = document.createTextNode("输入选项"+(i+1)+"内容:");
			    var br = document.createElement("br");
        	var username = document.createElement("input");
			    username.type="text";
			    var jianjie=document.createElement("textarea");
			    jianjie.type="text";
			    var kongge=document.createElement("label");
			    kongge.innerHTML="简介";
			    document.getElementById("finish").appendChild(br);
		   	 document.getElementById("finish").appendChild(str);
		     
			   document.getElementById("finish").appendChild(username);	
			   document.getElementById("finish").appendChild(kongge);
			   
         document.getElementById("finish").appendChild(jianjie);		 
		     
        	}

}
if(sel==1){
	    
	for(var i=0;i<document.getElementById("txt").value;i++){
		var br = document.createElement("br");
		var username = document.createElement("input");
		username.type="file";
		var str = document.createTextNode("输入选项"+(i+1)+"内容:");
	  var xiangqing=document.createElement("label");
		xiangqing.innerHTML="简介";
	  var jianjie=document.createElement("textarea");
	  jianjie.type="text";
	  var guanjianzi=document.createElement("label");
	  guanjianzi.innerHTML="关键字";
	  var guanjianzitxt=document.createElement("input");
	  guanjianzitxt.type="text";
	 
		document.getElementById("finish").appendChild(br);
		document.getElementById("finish").appendChild(str);
		document.getElementById("finish").appendChild(username);
		document.getElementById("finish").appendChild(guanjianzi);
		document.getElementById("finish").appendChild(guanjianzitxt);
		document.getElementById("finish").appendChild(xiangqing);
		document.getElementById("finish").appendChild(jianjie);
		}
	
}
	
		
	}
