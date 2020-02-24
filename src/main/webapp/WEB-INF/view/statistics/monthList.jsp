<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/jboa/">
<link href="css/style.css" rel="stylesheet" type="text/css">
<body>
	<div class="action  divaction">
		<div class="t">月度统计列表</div>
		<div class="pages">
			<form id="claimVoucherStatistics_getDeptStatisticsByMonth_action"
				name="queryForm" action="/jboa/c/TbCount/findMonthList?pageNum=1"
				method="post">
				<label for="time">年份</label> <select name="year"
					id="claimVoucherStatistics_getDeptStatisticsByMonth_action_year">
					<option value="0">无</option>
					<option value="2016">2016年</option>
					<option value="2017">2017年</option>
					<option value="2018">2018年</option>
					<option value="2019">2019年</option>
					<option value="2020">2020年</option>
				</select> <label for="time">开始月份</label> <select name="beginMonth"
					id="claimVoucherStatistics_getDeptStatisticsByMonth_action_startMonth">
					<option value="0">无</option>
					<option value="1">1月份</option>
					<option value="2">2月份</option>
					<option value="3">3月份</option>
					<option value="4">4月份</option>
					<option value="5">5月份</option>
					<option value="6">6月份</option>
					<option value="7">7月份</option>
					<option value="8">8月份</option>
					<option value="9">9月份</option>
					<option value="10">10月份</option>
					<option value="11">11月份</option>
					<option value="12">12月份</option>
				</select> <label for="end-time">结束月份</label> <select name="endMonth"
					id="claimVoucherStatistics_getDeptStatisticsByMonth_action_endMonth">
					<option value="0">无</option>
					<option value="1">1月份</option>
					<option value="2">2月份</option>
					<option value="3">3月份</option>
					<option value="4">4月份</option>
					<option value="5">5月份</option>
					<option value="6">6月份</option>
					<option value="7">7月份</option>
					<option value="8">8月份</option>
					<option value="9">9月份</option>
					<option value="10">10月份</option>
					<option value="11">11月份</option>
					<option value="12">12月份</option>
				</select> <input type="submit"
					id="claimVoucherStatistics_getDeptStatisticsByMonth_action_0"
					value="查询" class="submit_01">
				<button type="button" id="execlInfo" class="submit_01">批量导出Execl</button>
			</form>
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="list items">
				<thead>
					<tr class="even">
						<td>编号</td>
						<td>总计</td>
						<td>年份</td>
						<td>月份</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageList.list }" var="i" varStatus="j">
						<tr>
							<td>${j.count }</td>
							<td>￥${i.money }</td>
							<td>${i.year }年</td>
							<td>${i.month }月</td>
							<td><a target="rightFrame"
								href="/jboa/c/TbCount/monthDetails?year=${i.year }&month=${i.month }&money=${i.money}">
									<img src="images/search.gif" width="16" height="15">
							</a><input type="checkbox" name="execl" data-year="${i.year }"
								data-month="${i.month }" data-money="${i.money }"></td>
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
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$("[name=year] option[value=${year}]").attr("selected", true);
	$("[name=beginMonth] option[value=${beginMonth}]").attr("selected", true);
	$("[name=endMonth] option[value=${endMonth}]").attr("selected", true);

	$("#execlInfo").click(function() {
		if ($("input:checkbox:checked").length == 0) {
			alert("请选择至少一条数据！");
			return;
		}
		if (confirm("是否批量导出？")) {
			let years = "?";
			let months = "";
			let moneys = "";
			$("input:checkbox:checked").each(function(i, j) {
				years += "&years=" + $(j).attr("data-year");
				months += "&months=" + $(j).attr("data-month");
				moneys += "&moneys=" + $(j).attr("data-money");
			});
			location.href = "/jboa/c/Execl/month" + years + months + moneys;
		}
	});
</script>
</head>
</html>