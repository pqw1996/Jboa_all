<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/jboa/">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="action  divaction">
		<div class="t">报销单列表</div>
		<div class="pages">
			<div class="forms">
				<form id="myForm" name="queryForm"
					action="c/TbReimburse/findPageList?pageNum=1" method="post">
					<label>报销单状态</label> <select name="type" id="statusId">
						<option value="0">全部</option>
						<option value="1">新创建</option>
						<option value="2">待审批</option>
						<option value="3">审批中</option>
						<option value="4">已审批</option>
						<option value="5">已付款</option>
						<option value="6">已打回</option>
					</select> <label for="time">开始时间</label> <input type="text" name="sTime"
						value="" id="startDate" class="nwinput"> <label
						for="end-time">结束时间</label> <input type="text" name="eTime"
						value="" id="endDate" class="nwinput">
					<!-- <input
						type="hidden" name="pageNum" value="1"> <input
						type="hidden" name="pageSize" value="2"> -->
					<input type="submit" id="claimVoucher_searchClaimVoucher_action_0"
						value="查询" class="submit_01">
				</form>
			</div>
			<!--增加报销单 区域 开始-->
			<!-- <form id="claimVoucher_searchClaimVoucher_action"
				name="claimVoucherForm"
				action="jsp/claim/claimVoucher_searchClaimVoucher.action"
				method="post"> -->
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
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
					<c:forEach items="${pageList.list }" var="i" varStatus="j">
						<tr>
							<td><a href="javascript:void(0)">${j.count+(pageList.pageNum-1)*10 }</a></td>
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
							<td><c:if
									test="${i.statusid==1||(i.statusid==6&&(i.createman==emp.employeeid))}">
									<a class="sub"
										href="c/TbReimburse/submit?id=${i.reimburseid }&statusid=2&pageNum=${pageList.pageNum }&type=${type}&sTime=${sTime}&eTime=${eTime}">
										<img src="images/save.gif" title="提交" width="16" height="16">
									</a>
									<a
										href="c/TbReimburse/getDetails?id=${i.reimburseid }&choice=2">
										<img src="images/edit.gif" title="编辑" width="16" height="16">
									</a>
								</c:if> <c:if test="${i.createman==emp.employeeid }">
									<a onclick="return confirm('确定要删除吗？')"
										href="c/TbReimburse/delete?id=${i.reimburseid }&pageNum=${pageList.pageNum }&type=${type}&sTime=${sTime}&eTime=${eTime}&size=${pageList.size }">
										<img src="images/delete.gif" title="删除" width="16" height="16">
									</a>
								</c:if> <a target="rightFrame"
								href="c/TbReimburse/getDetails?id=${i.reimburseid }&choice=1">
									<img src="images/search.gif" title="查看详情" width="16"
									height="15">
							</a> <c:if
									test="${i.nextdealman==emp.employeeid&&i.check!=2&&(i.statusid>=2&&i.statusid<=4)}">
									<!-- 下个处理人是自己&&审查表最后一条意见不是拒绝&& -->
									<a target="rightFrame"
										href="c/TbReimburse/toCheck?id=${i.reimburseid }"> <img
										src="images/sub.gif" title="审批" width="16" height="15">
									</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
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
			</table>
			<!-- </form> -->
			<!--增加报销单 区域 结束-->
		</div>
	</div>
</body>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
	$("#startDate").val("${sTime}");
	$("#endDate").val("${eTime}");
	function show(pageNum) {
		location.href = "/jboa/c/TbReimburse/findPageList?pageNum=" + pageNum
				+ "&sTime=" + $("#startDate").val() + "&eTime="
				+ $("#endDate").val() + "&type=0";
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
	$("[name=type]>option[value=${type}]").attr("selected",true);
	$("#startDate").val("${sTime}");
	$("#endDate").val("${eTime}");
	$("#tip1,#tip2", window.parent.document).css("display", "none");
	$(".sub").click(function(){
		if(confirm('确定要提交么？(提交后无法修改)')){
			window.parent.websocket.send('${emp.pid}|1');
		}
	});
</script>
</html>