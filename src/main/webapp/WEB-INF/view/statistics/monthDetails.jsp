<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/jboa/">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="action  divaction" style="padding-bottom: 0px;">
		<div class="t">月度统计详情</div>
		<div class="pages">
				<label for="time">年份:</label> ${date.year } <label for="end-time">月份:</label>
				${date.month }
			<table width="90%" border="0" cellspacing="0" cellpadding="0"
				class="list items">
				<thead>
					<c:if test="${emp.positionid!=0}">
						<tr class="even">
							<td>编号</td>
							<td>报销人</td>
							<td>报销总额</td>
							<td>年份</td>
							<td>月份</td>
						</tr>
					</c:if>
					<c:if test="${emp.positionid==0}">
						<tr class="even">
							<td>编号</td>
							<td>报销总额</td>
							<td>年份</td>
							<td>月份</td>
							<td>部门</td>
						</tr>
					</c:if>
				</thead>
				<tbody>
					<c:if test="${emp.positionid!=0}">
						<c:forEach items="${date.list}" var="i" varStatus="j">
							<tr>
								<td>${j.count }</td>
								<td>${i.name }</td>
								<td>￥${i.money }</td>
								<td>${date.year }年</td>
								<td>${date.month }月</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${emp.positionid==0}">
						<c:forEach items="${date.list}" var="i" varStatus="j">
							<tr>
								<td>${j.count }</td>
								<td>￥${i.money }</td>
								<td>${date.year }年</td>
								<td>${date.month }月</td>
								<td>${i.name }</td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td></td>
						<td bgcolor="yellow">总计</td>
						<td bgcolor="yellow">￥${date.money }</td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- <span style="display: none;"><iframe id="downloadIframe" src=""
				style="width: 0px; height: 0px;"></iframe></span>
		增加报销单 区域 结束 -->
	</div>
	<div id="echartsDom"
		style='width: 702px; heigth: 400px; background: #fff; clear: both; padding-top: 20px; padding-left: 40px;'>
	</div>
	<div style="width: 542px; background: #fff; padding-left: 200px;">
		<input type="button" class="submit_01" value="查看柱状图"
			onclick="initEcharts('bar')" /> <input type="button"
			class="submit_01" value="查看饼图" onclick="initEcharts('pie')" /> <input
			type="button" class="submit_01" value="查看曲线图"
			onclick="initEcharts('line')" />
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/echarts.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function() {
		initEcharts('pie');
	});
	
	$("#execl").click(function(){
		
	});
	
	function initEcharts(type) {
		var data = ${eChartsDate};
		var xAxis = new Array();
		var legend = new Array();
		for (var i = 0; i < data.length; i++) {
			xAxis[i] = data[i].name;
			legend[i] = data[i].money;
		}
		var year = ${date.year};
		var month = ${date.month};
		var departmentName = "${dName}";
		var option = null;
		if (type == 'bar') {
			option = {
				title : {
					text : year + '年' + month + '月' + departmentName
							+ '月度报销统计图'
				},
				tooltip : {},
				legend : {
					data : [ '报销金额' ]
				},
				xAxis : {
					data : xAxis
				},
				yAxis : {},
				series : [ {
					name : '报销金额',
					type : 'bar',
					barWidth : 30,
					data : legend
				} ]
			};
		} else if (type == "pie") {
			option = {
				title : {
					text : year + '年' + month + '月' + departmentName
							+ '月度报销统计图'
				},
				tooltip : {},
				series : [ {
					name : '报销金额',
					type : 'pie',
					radius : '60%',
					label : {
						normal : {
							formatter : '{b}: ({d}%)',
							textStyle : {
								fontWeight : 'normal',
								fontSize : 15
							}
						}
					}
				} ],
				dataset : {
					source : data
				}
			};
		} else {
			option = {
				title : {
					text : year + '年' + month + '月' + departmentName
							+ '月度报销统计图'
				},
				tooltip : {},
				legend : {
					data : [ '报销金额' ]
				},
				xAxis : {
					data : xAxis
				},
				yAxis : {},
				series : [ {
					name : '报销金额',
					type : 'line',
					barWidth : 30,
					data : legend
				} ]
			};
		}
		var dom = document.getElementById('echartsDom');
		$("#echartsDom").height('400px');
		var myChart = echarts.init(dom);
		if (myChart != null && myChart != "" && myChart != undefined) {//关键
			myChart.dispose();
		}
		var myChart = echarts.init(dom);
		myChart.setOption(option);
	}
</script>
</html>