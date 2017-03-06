(function ($) {
	$.extend({
		tipsBox: function (options) {
			options = $.extend({
				obj: null,  //jq对象，要在那个html标签上显示
				str: "<b>+1</b>",  //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
				startSize: "16px",  //动画开始的文字大小
				endSize: "36px",    //动画结束的文字大小
				interval: 600,  //动画时间间隔
				color: "red",    //文字颜色
				callback: function () { }    //回调函数
			}, options);
			$("body").append("<span class='num'>" + options.str + "</span>");
			var box = $(".num");
			var left = options.obj.offset().left + options.obj.width() / 2;
			var top = options.obj.offset().top - options.obj.height();
			box.css({
				"position": "absolute",
				"left": left + "px",
				"top": top + "px",
				"z-index": 9999,
				"font-size": options.startSize,
				"line-height": options.endSize,
				"color": options.color
			});
			box.animate({
				"font-size": options.endSize,
				"opacity": "0",
				"top": top - parseInt(options.endSize) + "px"
			}, options.interval, function () {
				box.remove();
				options.callback();
			});
		}
	});
})(jQuery);
function niceIn(prop){
	prop.find('i').addClass('niceIn');
	setTimeout(function(){
		prop.find('i').removeClass('niceIn');	
	},1000);		
}
function chang(oid,tid){
	
	if(getCookie(tid)==null||getCookie(tid)==""){
		;
		$.ajax({
			url:"voteAction!addVote.do",
			type: "post",
			dataType:"json",
			data:{
				"oid":oid,
				"tid":tid,
				"action":new Date().getTime()
			},
			success : function(data){
			    if(data==1){
			    	var spans =$("#"+oid).find("span");
					$.tipsBox({
						obj: $(spans),
						str: "+1",
						callback: function () {
						}
					});
					niceIn($(spans))
			    	setCookie(tid,tid);
			    	var votecount=$("#voteSum").text();
					votecount=parseInt(votecount)+1;
					$("#voteSum").text(votecount);
				    voteSum=spans.last().find("b").text();
					voteSum=parseInt(voteSum)+1;
					spans.last().find("b").text(voteSum);
			    	//$("#piechart").attr("src","images/pie3DChart.jpg");
			    	//$("#barchart").attr("src","images/bar3DChart.jpg");
			    }
			}
		});
	}else{
		alert("不能重复投票");
	}
}
function setCookie(name,value)
{
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
}