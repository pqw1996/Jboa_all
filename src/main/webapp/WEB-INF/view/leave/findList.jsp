<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/jboa/">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link
	href="http://localhost:8080/jboa/js/My97DatePicker/skin/WdatePicker.css"
	rel="stylesheet" type="text/css">
<script>
	$(function() {
		//日期选择控件
		$("#startDate").click(function() {
			WdatePicker({
				dateFmt : 'yyyy-MM-dd',
				maxDate : '#F{$dp.$D(\'endDate\')}',
				isShowClear : true,
				readOnly : true
			});
		});
		$("#endDate").click(function() {
			WdatePicker({
				dateFmt : 'yyyy-MM-dd',
				minDate : '#F{$dp.$D(\'startDate\')}',
				isShowClear : true,
				readOnly : true
			});
		});
	});
</script>
</head>
<body>
	<div class="action  divaction">
		<div class="t">请假列表</div>
		<div class="pages">
			<div class="forms">
				<form id="leave_searchLeave_action" name="queryForm"
					action="/jboa/c/TbLeave/findPageList" method="post">
					<label for="time">开始时间</label> <input type="text" name="sTime"
						value="" id="startDate" class="nwinput" readonly="readonly">
					<label for="end-time">结束时间</label> <input type="text" name="eTime"
						value="" id="endDate" class="nwinput" readonly="readonly">
					<input type="hidden" name="pageNum" value="1"> <input
						type="submit" id="leave_searchLeave_action_0" value="查询"
						class="submit_01">

				</form>
			</div>
			<!--增加报销单 区域 开始-->
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
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
					<c:forEach items="${pageList.list }" var="i" varStatus="j">
						<tr>
							<td><a href="javascript:void(0)">${j.count+(pageList.pageNum-1)*10 }</a></td>
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
									<img src="images/search.gif" width="16" height="15">
							</a> <c:if
									test="${i.nextdealman==emp.employeeid&&i.statusid==2&&emp.positionid==1}">
									<a href="/jboa/c/TbLeave/getOne?type=2&id=${i.leaveid }"> <img
										src="images/sub.gif" width="16" height="16">
									</a>
								</c:if> <c:if
									test="${i.nextdealman==emp.employeeid&&i.statusid==4&&emp.positionid==4}">
									<a href="/jboa/c/TbLeave/getOne?type=2&id=${i.leaveid }"> <img
										src="images/sub.gif" width="16" height="16">
									</a>
								</c:if> <c:if
									test="${i.nextdealman==emp.employeeid&&i.statusid==2&&emp.positionid==0}">
									<a href="/jboa/c/TbLeave/getOne?type=2&id=${i.leaveid }"> <img
										src="images/sub.gif" width="16" height="16">
									</a>
								</c:if></td>
						</tr>
					</c:forEach>
					<!-- <tr>
						<td><a href="leave_getLeaveById.action?leave.id=143">143</a></td>
						<td>张平请假1.0天</td>
						<td>2013-09-09 15:10</td>
						<td></td>
						<td></td>
						<td>待审批</td>
						<td>
							<a href="claimVoucher_toUpdate.action?claimVoucher.id=133">
									<img src="images/edit.gif" width="16" height="16">
							</a> 
							<a onclick="delVoucher(133)" href="#"> <img
								src="images/delete.gif" width="16" height="16">
							</a> 
							<a target="rightFrame" href="leaveDetail.jsp"><img
								src="images/search.gif" width="16" height="15"></a>
							<a target="rightFrame" href="leaveCheck.jsp"> <img
								src="images/sub.gif" width="16" height="16"></a></td>
					</tr> -->

					<tr>
						<td colspan="7" align="center">
							<div class="page-bar">
								<a href="javascript:void(0)" id="firstPage">首页</a> &nbsp;&nbsp;
								<c:if test="${pageList.hasPreviousPage }">
									<a href="javascript:void(0)" id="prePage">上一页</a>
								</c:if>
								&nbsp;&nbsp;
								<c:if test="${pageList.hasNextPage }">
									<a href="javascript:void(0)" id="nextPage">下一页</a>
								</c:if>
								&nbsp;&nbsp; <a href="javascript:void(0)" id="lastPage">末页</a>
								&nbsp;&nbsp; &nbsp;&nbsp;第${pageList.pageNum }页/共${pageList.pages }页&nbsp;&nbsp;共${pageList.total }条记录
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<!--请假 区域 结束-->
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$("#startDate").val("${sTime}");
	$("#endDate").val("${eTime}");
	function show(pageNum) {
		location.href = "/jboa/c/TbLeave/findPageList?pageNum=" + pageNum
				+ "&sTime=" + $("#startDate").val() + "&eTime="
				+ $("#endDate").val();
	}
	$("#firstPage").click(function() {
		show(${pageList.firstPage });
	});
	$("#prePage").click(function(){
		show(${pageList.pageNum-1 });
	});
	$("#nextPage").click(function(){
		show(${pageList.pageNum+1 });
	});
	$("#lastPage").click(function() {
		show(${pageList.lastPage });
	});
	$("#tip3,#tip4", window.parent.document).css("display", "none");
</script>
</html>