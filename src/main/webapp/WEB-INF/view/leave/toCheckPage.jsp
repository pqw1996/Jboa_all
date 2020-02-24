<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/jboa/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大青鸟办公自动化管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="action  divaction">
		<div class="t">审批请假</div>
		<div class="pages">
			<!--增加报销单 区域 开始-->
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="addform-base">
				<caption>基本信息</caption>
				<tbody>
					<tr>
						<td width="36%">姓名：${l.createmanName }</td>
						<td width="64%">部门：${l.departmentName }</td>
					</tr>
					<tr>
						<td>开始时间：${l.starttime }</td>
						<td>结束时间：${l.endtime }</td>
					</tr>
					<tr>
						<td>请假天数：${l.totalcount }</td>
						<td>请假事由：${l.event }</td>
					</tr>
					<tr>
						<c:if test="${l.statusid==2}">
							<td>审批状态：待审批</td>
						</c:if>
						<c:if test="${l.statusid==4}">
							<td>审批状态：已审批</td>
						</c:if>
						<c:if test="${l.statusid==7}">
							<td>审批状态：已存档</td>
						</c:if>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<p>
				-------------------------------------------------------------------------------
			</p>
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="addform-base" style="margin: 20px 0;">
				<thead>

					<tr>
						<td width="15%">审查人</td>
						<td width="40%">审查意见</td>
						<td width="30%">审查时间</td>
						<td width="15%">审查结果</td>
					</tr>

				</thead>
				<tbody>
					<c:set var="startIndex" value="${fn:length(l.checkList)-1}" />
					<c:forEach items="${l.checkList }" varStatus="j">
						<tr>
							<td>${l.checkList[startIndex-j.index].checkmanName }</td>
							<td>${l.checkList[startIndex-j.index].checkcomment }</td>
							<td>${l.checkList[startIndex-j.index].checktime }</td>
							<c:if test="${l.checkList[startIndex-j.index].checkresult==1 }">
								<td style="font-weight: bold;">通过</td>
							</c:if>
							<c:if test="${l.checkList[startIndex-j.index].checkresult==2 }">
								<td style="font-weight: bold;">拒绝</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<form id="leave_checkLeave_action" name="leaveForm"
				action="/jboa/c/TbLeave/checkLeave" method="post">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<tbody>
						<tr>
							<td>审批意见：</td>
						</tr>
						<tr>
							<td><textarea name="checkComment" id="textarea" cols="45"
									rows="5"></textarea></td>
						</tr>
						<!--表单提交行-->
						<tr>
							<td colspan="4" class="submit"><c:if
									test="${emp.positionid==4}">
									<input type="button" name="button" id="button" value="存档"
										class="submit_01" onclick="checkLeave('存档')">
								</c:if> <c:if test="${emp.positionid==1||emp.positionid==0}">
									<input type="button" name="button" id="button" value="审批通过"
										class="submit_01" onclick="checkLeave('通过')">
									<input type="button" name="button" id="button" value="审批拒绝"
										class="submit_01" onclick="checkLeave('拒绝')">
								</c:if> <input type="hidden" name="leaveId" value="${l.leaveid }"
								id="leaveId"> <input type="hidden" name="statusId"
								value="" id="status"></td>
						</tr>
						<tr>
							<td>
								<p>&nbsp;</p>
								<p>
									<input type="button" value="返回" onclick="window.history.go(-1)"
										class="submit_01">
								</p>
							</td>
						</tr>

					</tbody>
				</table>
			</form>
			<!--增加报销单 区域 结束-->
		</div>
	</div>

</body>
<script type="text/javascript">
	function checkLeave(status) {
		if (!confirm('确定' + status + '请假吗'))
			return;
		if (status != "拒绝") {
			document.leaveForm.status.value = 1;
			if (${emp.positionid == 1} || ${emp.positionid == 0}) {
				window.parent.websocket.send("1017|1");
			} else {
				window.parent.websocket.send("${l.createman}|2");
			}
		} else {
			document.leaveForm.status.value = 2;
			window.parent.websocket.send("${l.createman}|2");
		}
		document.leaveForm.submit();
	}
</script>
</html>