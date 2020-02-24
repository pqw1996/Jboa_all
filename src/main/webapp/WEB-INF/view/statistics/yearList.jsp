<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/jboa/">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function submitSearch() {
		if (document.queryForm.endYear.value < document.queryForm.beginYear.value) {
			alert("请输入正确的年份区间");
			return false;
		}
		document.queryForm.submit();
	}
</script>
</head>
<body>
	<div class="action  divaction">
		<div class="t">年度统计列表</div>
		<div class="pages">
			<form id="compYearStatistics_getList_action" name="queryForm"
				action="/jboa/c/TbCount/findYearList" method="post">
				<input type="hidden" name="pageNum" value="1"> <label
					for="time">开始年份</label> <select name="beginYear" id="beginYear"
					class="nwinput">
					<option value="0">无</option>
					<option value="2015">2015年</option>
					<option value="2016">2016年</option>
					<option value="2017">2017年</option>
					<option value="2018">2018年</option>
					<option value="2019">2019年</option>
					<option value="2020">2020年</option>
				</select> <label for="end-time">结束年份</label> <select name="endYear"
					id="endYear" class="nwinput">
					<option value="0">无</option>
					<option value="2015">2015年</option>
					<option value="2016">2016年</option>
					<option value="2017">2017年</option>
					<option value="2018">2018年</option>
					<option value="2019">2019年</option>
					<option value="2020">2020年</option>
				</select> <input type="button" value="提交" class="submit_01"
					onclick="submitSearch()">
				<button type="button" id="execlInfo" class="submit_01">批量导出Execl</button>
			</form>
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="list items">
				<thead>
					<tr class="even">
						<td>编号</td>
						<td>总计</td>
						<td>年份</td>
						<!--  <td>月份</td> -->
						<!-- <td>部门</td> -->
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageList.list }" var="i" varStatus="j">
						<tr>
							<td>${j.count}</td>
							<td>￥${i.money }</td>
							<td>${i.year }年</td>
							<td><a
								href="/jboa/c/TbCount/yearDetails?year=${i.year }&money=${i.money}"
								target="rightFrame"> <img src="images/search.gif" width="16"
									height="15">
							</a><input type="checkbox" name="execl" data-year="${i.year }"
								data-money="${i.money }"></td>
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
	$("[name=beginYear] option[value=${beginYear}]").attr("selected", true);
	$("[name=endYear] option[value=${endYear}]").attr("selected", true);

	$("#execlInfo").click(function() {
		if ($("input:checkbox:checked").length == 0) {
			alert("请选择至少一条数据！");
			return;
		}
		if (confirm("是否批量导出？")) {
			let years = "?";
			let moneys = "";
			$("input:checkbox:checked").each(function(i, j) {
				years += "&years=" + $(j).attr("data-year");
				moneys += "&moneys=" + $(j).attr("data-money");
			});
			location.href = "/jboa/c/Execl/year" + years + moneys;
		}
	});
</script>
</html>