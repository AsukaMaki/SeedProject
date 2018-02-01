<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
		$(function(){
			$("#btn_dele").click(function() {
				if($("input:checked").size()<1){
					alert("请至少选择一项");
					return;
				}
				if(confirm("删除确认")){
					$("#fom").submit();
				}
			})
		})
		
	})
</script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />

<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function selectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "addCompany.jsp";
		document.getElementById("fom").submit();
	}
</SCRIPT>
</head>
<body>
	<form name="fom" id="fom" method="post" action="delete.do">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="../images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="24"><img src="../images/ico07.gif" width="20"
											height="18" /></td>
										<td width="519"><label>公司名称: <input name="text"
												type="text" name="gongs" />
										</label> <input name="Submit" type="button" class="right-button02"
											value="查 询" /></td>
										<td width="679" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY:" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="20"><span class="newfont07">选择：<a
												href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
											<input name="Submit" type="button" class="right-button08"
											value="删除所选公司信息" id="btn_dele" /> <input name="Submit"
											type="button" class="right-button08" value="添加公司信息"
											onclick="link();" />
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									<tr>
										<td height="40" class="font42"><table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">

												<tr>
													<td height="20" colspan="14" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户详细列表
														&nbsp;</td>
												</tr>
												<tr>
													<td width="8%" align="center" bgcolor="#EEEEEE">选择</td>
													<td width="12%" height="20" align="center"
														bgcolor="#EEEEEE">公司名称</td>
													<td width="7%" align="center" bgcolor="#EEEEEE">联系人</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">联系电话</td>
													<td width="14%" align="center" bgcolor="#EEEEEE">联系地址</td>
													<td width="28%" align="center" bgcolor="#EEEEEE">公司背景</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">添加时间</td>
													<td width="11%" align="center" bgcolor="#EEEEEE">操作</td>
												</tr>

												<c:forEach items="${pageInfo.list }" var="cl">
													<tr>
														<td bgcolor="#FFFFFF"><input type="checkbox"
															name="delid" value="${cl.companyID }" /></td>
														<td height="20" bgcolor="#FFFFFF"><a
															href="listyuangongmingxi.html">${cl.companyName }</a></td>
														<td bgcolor="#FFFFFF"><a
															href="listyuangongmingxi.html">${cl.linkMan }</a></td>
														<td height="20" bgcolor="#FFFFFF">${cl.tel }</td>
														<td bgcolor="#FFFFFF">${cl.address }</td>
														<td bgcolor="#FFFFFF">${cl.descript }</td>
														<td bgcolor="#FFFFFF">${cl.createDate }</td>
														<td bgcolor="#FFFFFF"><a href="alter.do?companyId=${cl.companyID }">编辑</a>&nbsp;|&nbsp;<a
															href="kehuminxi.html">查看</a></td>
													</tr>
												</c:forEach>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table>
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="6"><img src="../images/spacer.gif" width="1"
								height="1" /></td>
						</tr>
						<tr>
							<td height="33">
								<%@ include file="subPage.jsp" %>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
