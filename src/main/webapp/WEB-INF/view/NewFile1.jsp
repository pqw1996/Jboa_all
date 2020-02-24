<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
h1 {
	background: white;
}
</style>
</head>
<body>
	<div class="action  divaction">
		<div class="t">审查提醒</div>
		<c:if
			test="${emp.positionid==4||emp.positionid==0||emp.positionid==1 }">
			<h1>请假列表</h1>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="list items">
				<thead>
					<tr class="even">
						<td>序号</td>
						<td>名称</td>
						<td>发起时间</td>
						<td>审批时间</td>
						<td>审批意见</td>
						<td>待处理人</td>
						<td>审批状态</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageList1.list }" var="i" varStatus="j">
						<tr>
							<td><a href="javascript:void(0)">${j.count }</a></td>
							<td>${i.createmanName }请假${i.totalcount }天</td>
							<td>${i.createtime }</td>
							<td>${i.checkList[0].checktime}</td>
							<c:if test="${i.checkList[0].checkresult==1}">
								<td>通过</td>
							</c:if>
							<c:if test="${i.checkList[0].checkresult==2}">
								<td>拒绝</td>
							</c:if>
							<c:if test="${i.checkList[0].checkresult==null}">
								<td></td>
							</c:if>
							<td>${i.nextdealmanName }</td>
							<c:if test="${i.statusid==2}">
								<td>待审批</td>
							</c:if>
							<c:if test="${i.statusid==4}">
								<td>已审批</td>
							</c:if>
							<c:if test="${i.statusid==7}">
								<td>已存档</td>
							</c:if>
							<td><a href="/jboa/c/TbLeave/getOne?type=1&id=${i.leaveid }">
									<img src="../../images/search.gif" width="16" height="15">
							</a> <c:if
									test="${i.nextdealman==emp.employeeid&&i.statusid==2&&emp.positionid==1}">
									<a href="/jboa/c/TbLeave/getOne?type=2&id=${i.leaveid }"> <img
										src="../../images/sub.gif" width="16" height="16">
									</a>
								</c:if> <c:if
									test="${i.nextdealman==emp.employeeid&&i.statusid==4&&emp.positionid==4}">
									<a href="/jboa/c/TbLeave/getOne?type=2&id=${i.leaveid }"> <img
										src="../../images/sub.gif" width="16" height="16">
									</a>
								</c:if> <c:if
									test="${i.nextdealman==emp.employeeid&&i.statusid==2&&emp.positionid==0}">
									<a href="/jboa/c/TbLeave/getOne?type=2&id=${i.leaveid }"> <img
										src="../../images/sub.gif" width="16" height="16">
									</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if
			test="${emp.positionid==3||emp.positionid==5||emp.positionid==0||emp.positionid==1}">
			<h1>报销列表</h1>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="list items">
				<thead>
					<tr class="even">
						<td>序号</td>
						<td>填报日期</td>
						<td>填报人</td>
						<td>总金额</td>
						<td>状态</td>
						<td>待处理人</td>
						<td width=20%>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageList2.list }" var="i" varStatus="j">
						<tr>
							<td><a href="javascript:void(0)">${j.count}</a></td>
							<td>${i.createtime }</td>
							<td>${i.createmanName }</td>
							<td>${i.totalcount }</td>
							<c:if test="${i.statusid==1 }">
								<td>新创建</td>
							</c:if>
							<c:if test="${i.statusid==2 }">
								<td>待审批</td>
							</c:if>
							<c:if test="${i.statusid==3 }">
								<td>审批中</td>
							</c:if>
							<c:if test="${i.statusid==4 }">
								<td>已审批</td>
							</c:if>
							<c:if test="${i.statusid==5 }">
								<td>已付款</td>
							</c:if>
							<c:if test="${i.statusid==6 }">
								<td>已打回</td>
							</c:if>
							<c:if test="${i.statusid==1 }">
								<td>${emp.employeename }</td>
							</c:if>
							<c:if test="${i.statusid!=1 }">
								<td>${i.nextdealmanName}</td>
							</c:if>
							<td><a target="rightFrame"
								href="/jboa/c/TbReimburse/getDetails?id=${i.reimburseid }&choice=1">
									<img src="../../images/search.gif" title="查看详情" width="16"
									height="15">
							</a> <c:if
									test="${i.nextdealman==emp.employeeid&&i.check!=2&&(i.statusid>=2&&i.statusid<=4)}">
									<!-- 下个处理人是自己&&审查表最后一条意见不是拒绝&& -->
									<a target="rightFrame"
										href="/jboa/c/TbReimburse/toCheck?id=${i.reimburseid }"> <img
										src="../../images/sub.gif" title="审批" width="16" height="15">
									</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$("#tip5,#tip6", window.parent.document).css("display", "none");
</script>
</html>