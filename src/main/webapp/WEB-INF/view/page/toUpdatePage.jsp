<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="/jboa/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大青鸟办公自动化管理系统</title>
<style type="text/css">
.preview {
	display: inline-block;
	width: 40px;
	height: 40px;
	position: relative;
	background-image: url("images/abcc.png");
	background-repeat: no-repeat;
	background-size: cover;
}

.file {
	width: 40px;
	height: 40px;
	opacity: 0;
	position: absolute;
	left: 0;
	top: 0;
	cursor: pointer;
	z-index: 5;
}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<div class="action  divaction">
		<div class="t">报销单更新</div>
		<div class="pages">
			<form id="claimVoucher_updateClaimVoucher_action" name="claimForm"
				enctype="multipart/form-data" action="c/TbReimburse/toUpdatePage"
				method="post">
				<input type="hidden" name="reimburseid" value="${trb.reimburseid }">
				<input type="hidden" name="statusid" value="${trb.statusid }">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<caption>基本信息</caption>
					<tbody>
						<tr>
							<td width="25%">编&nbsp;&nbsp;号：<input class="btn"
								type="button" id="look" data-id="${trb.reimburseid }" value="查看"></td>
							<td width="25%">填&nbsp;写&nbsp;人：${emp.employeename }</td>
							<c:if test="${emp.departmentid==1 }">
								<td width="25%">部&nbsp;&nbsp;门：财务部</td>
							</c:if>
							<c:if test="${emp.departmentid==2 }">
								<td width="25%">部&nbsp;&nbsp;门：人事部</td>
							</c:if>
							<c:if test="${emp.departmentid==3 }">
								<td width="25%">部&nbsp;&nbsp;门：研发部</td>
							</c:if>
							<c:if test="${emp.departmentid==4 }">
								<td width="25%">部&nbsp;&nbsp;门：测试部</td>
							</c:if>
							<c:if test="${emp.departmentid==5 }">
								<td width="25%">部&nbsp;&nbsp;门：市场部</td>
							</c:if>
							<c:if test="${emp.departmentid==6 }">
								<td width="25%">部&nbsp;&nbsp;门：产品部</td>
							</c:if>
							<c:if test="${emp.positionid==0 }">
								<td width="25%">职&nbsp;&nbsp;位：总经理</td>
							</c:if>
							<c:if test="${emp.positionid==1 }">
								<td width="25%">职&nbsp;&nbsp;位：部门经理</td>
							</c:if>
							<c:if test="${emp.positionid==2 }">
								<td width="25%">职&nbsp;&nbsp;位：普通员工</td>
							</c:if>
							<c:if test="${emp.positionid==3 }">
								<td width="25%">职&nbsp;&nbsp;位：财务</td>
							</c:if>
							<c:if test="${emp.positionid==4 }">
								<td width="25%">职&nbsp;&nbsp;位：人事</td>
							</c:if>
							<c:if test="${emp.positionid==5 }">
								<td width="25%">职&nbsp;&nbsp;位：出纳</td>
							</c:if>
						</tr>
						<tr>
							<td width="25%">总金额： <input type="text" name="totalcount"
								value="${trb.totalcount }" readonly="readonly" id="totalAccount"></td>
							<td width="25%">填报时间：${trb.createtime }</td>
							<c:if test="${trb.statusid==1 }">
								<td width="25%">状态：新创建</td>
							</c:if>
							<c:if test="${trb.statusid==2 }">
								<td width="25%">状态：待审批</td>
							</c:if>
							<c:if test="${trb.statusid==3 }">
								<td width="25%">状态：审批中</td>
							</c:if>
							<c:if test="${trb.statusid==4 }">
								<td width="25%">状态：已审批</td>
							</c:if>
							<c:if test="${trb.statusid==5 }">
								<td width="25%">状态：已付款</td>
							</c:if>
							<c:if test="${trb.statusid==6 }">
								<td width="25%">状态：已打回</td>
							</c:if>
							<c:if test="${trb.statusid==7 }">
								<td width="25%">状态：已存档</td>
							</c:if>
							<td width="25%">待处理人：${trb.nextdealmanName }</td>
						</tr>
						<tr>
							<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
						</tr>
					</tbody>
				</table>
				<table id="myTable" width="90%" border="0" cellspacing="0"
					cellpadding="0" class="addform-base">
					<thead>
						<tr>
							<td width="30%">项目说明</td>
							<td width="30%">项目金额</td>
							<td width="30%">票据截图</td>
							<td width="10%">操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rds }" var="i">
							<tr>
								<td><input type="hidden" name="desc" value="${i.desc }">
									<input type="hidden" name="ids" value="${i.id }"> <input
									type="hidden" name="opr" value="no"> ${i.desc }</td>
								<td><input type="hidden" name="subtotal"
									value="${i.subtotal }"> ${i.subtotal }</td>
								<td>
									<div class="preview"
										style="background-image: url(${i.imgs});background-size: cover;">
										<input type="file" name="imgs" accept="image/*" class="file"
											value="" />
									</div>
								</td>
								<td><img src="images/delete.gif" width="16" height="16"
									onclick="delRow(this)"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<table id="detailTable" width="90%" border="0" cellspacing="0"
					cellpadding="0" class="addform-base">
					<tbody>
						<tr>
							<td width="30%"><input type="text" id="item"></td>
							<td width="30%"><input type="text"
								name="claimVoucherDetail.account" id="account"></td>
							<td width="30%">
								<div class="preview">
									<input type="file" name="imgs" accept="image/*" class="file"
										value="">
								</div>
							</td>
							<td width="10%"><img src="images/add.gif" width="16"
								height="16" id="AddRow"></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<tr>
							<td>*事由：</td>
							<td colspan="3"><textarea name="event" cols="66" rows="5"
									id="event">${trb.event }</textarea></td>
						</tr>
						<tr align="center" colspan="4">
							<td>&nbsp;</td>
							<td><input type="button" id="1" name="1" value="保存"
								class="submit_01" onclick="submitClaimVoucher('保存')"> <input
								type="button" id="2" name="2" value="提交" class="submit_01"
								onclick="submitClaimVoucher('提交')"> <input type="button"
								value="返回" onclick="window.history.go(-1)" class="submit_01"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	$("#AddRow")
			.click(
					function() {
						var totalAccount = $("#totalAccount").val();
						var tr = $("#myTable tr").eq(0).clone();
						++i;
						var j = i - 1;
						var item = $("#item").val();
						var account = $("#account").val();
						var imgEle = $(this).parent().prev().children()[0];
						var imgClone = $(imgEle).clone(true);
						totalAccount = parseFloat(totalAccount)
								+ parseFloat(account);
						var desc = $("#item").val();
						var files = $(".file");//[0].files[0];
						var file = files.get(files.length - 1).files[0];
						if (!file) {
							alert("请选择文件");
							i--;
							return;
						}
						if (item == "") {
							alert("请输入项目说明");
							i--;
							return false;
						}
						if (account == "") {
							alert("请输入项目金额");
							i--;
							return false;
						} else {
							if (isNaN(account)) {
								alert("请输入正确的数字");
								i--;
								return false;
							} else {
								if (account <= 0) {
									alert("请输入正确的数字");
									i--;
									return false;
								}
							}
						}

						tr.find("td").get(0).innerHTML = "<input type='hidden' name='desc' value='"+desc+"'><input type='hidden' name='opr' value='add'>"
								+ desc;
						tr.find("td").get(1).innerHTML = "<input  name='subtotal' id=account"+j+"  type=hidden value="+account+" />"
								+ account;
						var td2 = tr.find("td").get(2);
						$(td2).html("").append(imgClone);
						tr.find("td").get(3).innerHTML = "<img src=images/delete.gif width=16 height=16 id=DelRow"
								+ j + " onclick=delRow(this) />";
						tr.show();
						tr.appendTo("#myTable");
						//传递一共添加多少问题 
						rowNumber = i;
						$("#item").val("");
						$("#account").val("");
						$(imgEle.children[0]).attr("value", "");
						$(imgEle).css("background-image",
								"url('images/abcc.png')");
						$("#totalAccount").val(totalAccount);
					});
	var i = parseInt(1);

	var rowNumber = parseInt(1);

	function delRow(obj) {
		if (!confirm("确定要删除这条记录吗？"))
			return;
		var totalCount = $("#totalAccount").val();
		var count = $(obj).parent().prev().prev().children()[0].value;
		totalCount = parseInt(totalCount) - parseInt(count);
		$("#totalAccount").val(totalCount);
		$(obj).parent().parent().remove();

	}
	function submitClaimVoucher(action) {
		if ($("[name='opr']").size() < 1) {
			alert("至少输入一条项目");
			return false;
		}
		var array = new Array();
		$("[name='imgs']").each(
				function(i, j) {
					if (i != $("[name='imgs']").size() - 1
							&& $(this).val() == ""
							&& $("[name=opr]").eq(i).val() != "no") {
						array.push((i + 1));
					}
				});
		if (array.length > 0) {
			var str = array.join("、");
			alert("第" + str + "条项目没有图片，无法提交");
			return false;
		}
		if (!confirm("确定" + action + "报销单吗")) {
			return;
		}
		if (action == '保存') {
			document.claimForm.statusid.value = 1;
		} else {
			document.claimForm.statusid.value = 2;
			window.parent.websocket.send("${emp.pid}|1");
		}
		document.claimForm.submit();
	}
</script>

<script type="text/javascript">
	var count = 0;
	$(".file")
			.change(
					function() {
						$("[name='imgs']")
								.each(
										function(i, j) {
											if (i != $("[name='imgs']").size() - 1
													&& $(this).val() == ""
													&& $("[name=opr]").eq(i)
															.val() != "no") {
												$(".preview")[i].style.backgroundImage = "url()";
											} else if (i == $("[name='imgs']")
													.size() - 1
													&& $(this).val() == "") {
												$(".preview")[i].style.backgroundImage = "url(images/abcc.png)";
											}
										});
						var file = this.files[0];
						// 确认选择的文件是图片
						for (var i = 0; i < $(".file").length; i++) {
							if ($(".file")[i] == this) {
								if ($("[name='opr']:eq(" + i + ")").val() != "add") {
									$("[name='opr']:eq(" + i + ")").val("yes");
								}
								count = i;
								if (file.type.indexOf("image") == 0) {
									var reader = new FileReader();
									reader.readAsDataURL(file);
									reader.onload = function(e) {
										// 图片base64化
										var newUrl = this.result;
										$(".preview")[count].style.backgroundImage = "url("
												+ newUrl + ")";
									};
								}
							}
						}
					});
	$("#look").click(function() {
		alert("编号：" + $(this).attr("data-id"));
	});
</script>
</html>