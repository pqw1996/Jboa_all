<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>北大青鸟办公自动化管理系统</title>
<style>
.action {
	background-color: #fff;
	float: right;
	width: 759px;
	padding-bottom: 69px;
	background: url(../images/right.gif) no-repeat 0 bottom;
}

* {
	margin: 0;
	padding: 0;
}

body {
	font: 12px 宋体;
}

div {
	display: block;
}

img {
	border: 0px;
}

a {
	color: #000;
	text-decoration: none;
}

.global-width {
	width: 971px;
	margin: 0 auto;
}

.top {
	background: url("images/Top_bg.gif") repeat-x;
	width: 100%;
	height: 88px;
}

.top .logo {
	margin: 17px 0 0 0;
}

.status {
	width: 100%;
	height: 36px;
	background: url(images/Top_bg.gif) repeat-x 0 bottom;
	line-height: 36px;
}

.usertype {
	color: #2357E7;
	margin-right: 30px;
}

.main {
	background: #4E93BB;
	height: 100%;
	overflow: hidden;
	padding: 14px 0;
}

.nav {
	float: left;
	width: 191px;
	padding-bottom: 69px;
	background: url(images/left_bg.gif) no-repeat -382px bottom;
}

.nav .t {
	height: 51px;
	background: url(images/left_bg.gif) no-repeat;
}

dt {
	display: block;
}

.nav dl {
	background: url(images/left_bg.gif) -191px 0 repeat-y;
	line-height: 22px;
	padding-left: 20px;
}

.nav dl.open dt {
	background-position: 0 0;
}

.nav dl dt {
	background: url(images/ico.gif) no-repeat 0 -23px;
	padding-left: 32px;
}

.nav dl.open dd {
	display: block;
}

.nav dl dd {
	background: url(images/ico.gif) no-repeat 18px -51px;
	padding-left: 36px;
	display: none;
}

.action {
	float: right;
	width: 759px;
	padding-bottom: 69px;
	background: url(images/right.gif) no-repeat 0 bottom;
}

.copyright {
	text-align: center;
	font: 12px Arial;
	margin: 20px 0;
	color: #000;
}

#loginOut {
	color: #2357E7;
	margin: 0 10px;
}

#tip1, #tip2, #tip3, #tip4, #tip5, #tip6 {
	width: 7px;
	height: 7px;
	background-color: red;
	border-radius: 50%;
	position: absolute;
	display: none;
}

#tip1, #tip2 {
	margin-left: 57px;
}

#tip3, #tip4, #tip5, #tip6 {
	margin-left: 45px;
}

audio {
	display: none;
}
</style>
</head>
<body>
	<div class="top">
		<div class="global-width">
			<img class="logo" src="images/logo.gif">
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			<c:if test="${emp.positionid==0 }">
				<span class="usertype">【登录角色：总经理】</span>
			</c:if>
			<c:if test="${emp.positionid==1 }">
				<span class="usertype">【登录角色：部门经理】</span>
			</c:if>
			<c:if test="${emp.positionid==2 }">
				<span class="usertype">【登录角色：普通员工】</span>
			</c:if>
			<c:if test="${emp.positionid==3 }">
				<span class="usertype">【登录角色：财务】</span>
			</c:if>
			<c:if test="${emp.positionid==4 }">
				<span class="usertype">【登录角色：人事】</span>
			</c:if>
			<c:if test="${emp.positionid==5 }">
				<span class="usertype">【登录角色：出纳】</span>
			</c:if>
			<a id="loginOut" href="/jboa/c/Employee/loginOut"
				onclick="return confirm('确定要退出登录吗？')">退出登录</a> ${emp.employeename }你好！欢迎访问青鸟办公管理系统！
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			<div class="nav" id="nav">
				<div class="t"></div>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
						<div id="tip1"></div>
						报销单管理
					</dt>
					<dd>
						<a target="rightFrame" href="/jboa/addPage">新增报销单</a>
					</dd>
					<dd>
						<a target="rightFrame"
							href="/jboa/c/TbReimburse/findPageList?pageNum=1&type=0"><div
								id="tip2"></div>查看报销单</a>
					</dd>
				</dl>
				<dl>
					<dt
						onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
						<div id="tip3"></div>
						请假管理
					</dt>

					<dd>
						<a target="rightFrame" href="/jboa/addLeave">请假</a>
					</dd>

					<dd>
						<a target="rightFrame"
							href="/jboa/c/TbLeave/findPageList?pageNum=1"><div id="tip4"></div>查看请假</a>
					</dd>
				</dl>
				<c:if test="${emp.positionid==0 || emp.positionid==1}">
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">统计报表</dt>
						<dd>
							<a target="rightFrame"
								href="/jboa/c/TbCount/findMonthList?pageNum=1&year=0&beginMonth=0&endMonth=0">报销单月度统计</a>
						</dd>
						<dd>
							<a target="rightFrame"
								href="/jboa/c/TbCount/findYearList?beginYear=0&endYear=0&pageNum=1">报销单年度统计</a>
						</dd>
					</dl>
				</c:if>
				<c:if test="${emp.positionid!=2}">
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							<div id="tip5"></div>
							信息中心
						</dt>
						<dd>
							<a target="rightFrame" href="/jboa/c/Tip/findList"><div
									id="tip6"></div>审查提醒</a>
						</dd>
					</dl>
				</c:if>
			</div>
			<div class="action">
				<!--  onload="setIframeHeight(this)"  scrolling="no"-->
				<iframe name="rightFrame" style="WIDTH: 100%; HEIGHT: 600px;"
					src="welcome" frameborder="0" id="iframepage"></iframe>
			</div>
		</div>
	</div>
	<div class="copyright">Copyright &nbsp; © &nbsp; 北大青鸟</div>
	<audio id="music1"> <source src="music/1.mp3" type="audio/mp3" />
	</audio>
	<audio id="music2"> <source src="music/2.mp3" type="audio/mp3" />
	</audio>
	<audio id="music3"> <source src="music/3.mp3" type="audio/mp3" />
	</audio>
	<div id="message"></div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	/* function setIframeHeight(iframe) {
		if (iframe) {
			var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
			if (iframeWin.document.body) {
				iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
			}
		}
	};
		 
	window.onload = function () {
		setIframeHeight(document.getElementById('iframepage'));
	}; */
	var websocket = null;
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket(
				"ws://localhost:8080/jboa/WebSocket/${emp.employeeid}");
	} else {
		alert('当前浏览器 Not support websocket')
	}

	//连接发生错误的回调方法
	websocket.onerror = function() {
		setMessageInnerHTML("WebSocket连接发生错误");
	};

	//连接成功建立的回调方法
	websocket.onopen = function() {
		setMessageInnerHTML("WebSocket连接成功");
		//websocket.send("1004|Are you OK?");
	}

	//接收到消息的回调方法
	websocket.onmessage = function(event) {
		var music;
		switch (event.data) {
		case "1":
			<!--提醒-->
			$("#tip5,#tip6").css("display", "block");
			music = document.getElementById('music1');
			break;
		case "2":
			<!--请假审批-->
			$("#tip3,#tip4").css("display", "block");
			music = document.getElementById('music2');
			break;
		case "3":
			<!--报销审批-->
			$("#tip1,#tip2").css("display", "block");
			music = document.getElementById('music2');
			break;
		case "4":
			<!--报销打回-->
			$("#tip1,#tip2").css("display", "block");
			music = document.getElementById('music3');
			break;
		}
		music.play();
		setMessageInnerHTML(event.data);
	}

	//连接关闭的回调方法
	websocket.onclose = function() {
		setMessageInnerHTML("WebSocket连接关闭");
	}

	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function() {
		closeWebSocket();
	}

	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('message').innerHTML += innerHTML + '<br/>';
	}

	//关闭WebSocket连接
	function closeWebSocket() {
		websocket.close();
	}

	//发送消息
	function send() {
		var message = document.getElementById('text').value;
		websocket.send(message);
	}
</script>
</html>
