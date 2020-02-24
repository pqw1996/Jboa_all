<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/jboa/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<style>
.img {
	width: 40px;
	height: 40px;
	cursor: pointer;
}

.weight {
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="action  divaction">
		<div class="t">审核报销单</div>
		<div class="pages">
			<!--增加报销单 区域 开始-->
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="addform-base">
				<caption>基本信息</caption>
				<tbody>
					<tr>
						<td>编&nbsp;&nbsp;号：<input class="btn" type="button" id="look"
							data-id="${trb.reimburseid }" value="查看"></td>
						<td>填&nbsp;写&nbsp;人：${emp.employeename }</td>
						<c:if test="${emp.departmentid==1 }">
							<td>部&nbsp;&nbsp;门：财务部</td>
						</c:if>
						<c:if test="${emp.departmentid==2 }">
							<td>部&nbsp;&nbsp;门：人事部</td>
						</c:if>
						<c:if test="${emp.departmentid==3 }">
							<td>部&nbsp;&nbsp;门：研发部</td>
						</c:if>
						<c:if test="${emp.departmentid==4 }">
							<td>部&nbsp;&nbsp;门：测试部</td>
						</c:if>
						<c:if test="${emp.departmentid==5 }">
							<td>部&nbsp;&nbsp;门：市场部</td>
						</c:if>
						<c:if test="${emp.departmentid==6 }">
							<td>部&nbsp;&nbsp;门：产品部</td>
						</c:if>
						<c:if test="${emp.positionid==0 }">
							<td>职&nbsp;&nbsp;位：总经理</td>
						</c:if>
						<c:if test="${emp.positionid==1 }">
							<td>职&nbsp;&nbsp;位：部门经理</td>
						</c:if>
						<c:if test="${emp.positionid==2 }">
							<td>职&nbsp;&nbsp;位：普通员工</td>
						</c:if>
						<c:if test="${emp.positionid==3 }">
							<td>职&nbsp;&nbsp;位：财务</td>
						</c:if>
						<c:if test="${emp.positionid==4 }">
							<td>职&nbsp;&nbsp;位：人事</td>
						</c:if>
						<c:if test="${emp.positionid==5 }">
							<td>职&nbsp;&nbsp;位：出纳</td>
						</c:if>
					</tr>
					<tr>
						<td>总金额：${trb.totalcount }</td>
						<td>填报时间：${trb.createtime }</td>
						<c:if test="${trb.statusid==1 }">
							<td>状态：新创建</td>
						</c:if>
						<c:if test="${trb.statusid==2 }">
							<td>状态：待审批</td>
						</c:if>
						<c:if test="${trb.statusid==3 }">
							<td>状态：审批中</td>
						</c:if>
						<c:if test="${trb.statusid==4 }">
							<td>状态：已审批</td>
						</c:if>
						<c:if test="${trb.statusid==5 }">
							<td>状态：已付款</td>
						</c:if>
						<c:if test="${trb.statusid==6 }">
							<td>状态：已打回</td>
						</c:if>
						<c:if test="${trb.statusid==7 }">
							<td>状态：已存档</td>
						</c:if>
						<td>待处理人：${trb.nextdealmanName }</td>
					</tr>
					<tr>
						<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
					</tr>
				</tbody>
			</table>
			<p>&nbsp;</p>
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="addform-base">
				<thead>
					<tr>
						<td>项目说明</td>
						<td>项目金额</td>
						<td>票据截图</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rds }" var="i">
						<tr>
							<td><span>${i.desc }</span></td>
							<td><span>${i.subtotal }</span></td>
							<td><img class="img" title="点击看大图" src="${i.imgs }"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>&nbsp;</p>
			<p>-------------------------------------------------------------------------------</p>

			<table style="margin: 15px 0;" width="90%" border="0" cellspacing="0"
				cellpadding="0" class="addform-base">
				<thead>

				</thead>
				<tbody>


				</tbody>
			</table>
			<form id="checkResult_checkClaimVoucher_action"
				name="checkResultForm" action="c/TbReimburse/updateStatus"
				method="post">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<tbody>
						<tr>
							<td>审批意见：</td>
						</tr>
						<tr>
							<td><textarea name="checkcomment" id="textarea" cols="45"
									rows="5"></textarea></td>
						</tr>
						<!--表单提交行-->
						<tr>
							<td colspan="3" class="submit"><input type="button"
								name="button" id="button" value="审批通过" class="submit_01"
								onclick="checkClaimVoucher('通过')"> <input type="hidden"
								name="bizid" value="${trb.reimburseid }" id="claimId"> <input
								type="hidden" name="checkresult" value="" id="result"> <c:if
									test="${sessionScope.emp.positionid!=5 }">
									<input type="button" name="button" id="button" value="打回"
										class="submit_01" onclick="checkClaimVoucher('打回')">
								</c:if> <c:if
									test="${sessionScope.emp.positionid!=5&&sessionScope.emp.positionid!=3}">
									<input type="button" name="button" id="button" value="拒绝"
										class="submit_01" onclick="checkClaimVoucher('拒绝')">
								</c:if></td>
						</tr>
					</tbody>
				</table>
			</form>
			<p>&nbsp;</p>

			<p>&nbsp;</p>
			<p>
				<input type="button" value="返回" onclick="window.history.go(-1)"
					class="submit_01">
			</p>
			<!--增加报销单 区域 结束-->
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/dialog.js"></script>
<script type="text/javascript">
	//创建图片放大框
	var $enlargement = $('<div id="enlargement" class="modal fade" data-backdrop="static" data-keyboard="false"><div class="modal-dialog modal-sm"><div class="modal-content"><div class="modal-header"><button class="close" data-dismiss="modal">&times;</button><h5 class="modal-title">查看图片</h5></div><div class="modal-body"><img style="width: 100%;" src=""></div><div class="modal-footer" style="text-align: center;"><button class="btn btn-info" data-dismiss="modal">确认</button></div></div></div></div>');
	$("body").append($enlargement);
	//图片放大框
	function showEnlargement(src) {
		$("#enlargement").find(".modal-body img").attr("src", src);
		$("#enlargement").modal(); // 显示
	}

	function closeEnlargement() {
		$("#enlargement").modal('hide'); // 隐藏
	}
	$("#look").click(function() {
		showAlertDialog($(this).attr("data-id"));
	});
	$(".img").click(function() {
		showEnlargement($(this).attr("src"));
	});
	function checkClaimVoucher(checkResult) {
		if ($("#textarea").val().trim() == "") {
			alert("请填写意见！");
			return;
		}
		if (!confirm('确定' + checkResult + '报单吗')){
			return;
		}			
		if (checkResult == "通过") {
			document.checkResultForm.result.value = 1;
			if(${sessionScope.emp.positionid==0}){
				window.parent.websocket.send("1001|1");
			}
			if(${sessionScope.emp.positionid==1}){
				if(${trb.totalcount>=5000}){
					window.parent.websocket.send("1000|1");
				}else{
					window.parent.websocket.send("1001|1");
				}
			}
			if(${sessionScope.emp.positionid==3}){
				window.parent.websocket.send("1002|1");
				window.parent.websocket.send("${trb.createman}|3");
			}
			if(${sessionScope.emp.positionid==5}){
				window.parent.websocket.send("${trb.createman}|3");
			}
		} else if (checkResult == "拒绝") {
			document.checkResultForm.result.value = 2;
			window.parent.websocket.send("${trb.createman}|3");
		} else {
			document.checkResultForm.result.value = 3;
			window.parent.websocket.send("${trb.createman}|4");
		}
		document.checkResultForm.submit();

	}
</script>
</html>