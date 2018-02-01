<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/JavaScript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#lastPage").click(function() {
			var currentPage = $("#currentPage").text();
			if (currentPage == 1) {
				$("#lastPage").prop("href", "");
			}
		})
		$("#nextPage").click(function() {
			var currentPage = $("#currentPage").text();
			var pageCount = $("#pageCount").text();
			if (currentPage == pageCount) {
				$("#nextPage").prop("href", "");
			}
		})
		$("#btn_sub").click(
				function() {
					var targetPage = $("#targetPage").val();
					var pageCount = $("#pageCount").text();
					var reg = /^[1-9][0-9]*$/;
					if (reg.test(targetPage)) {
						if (targetPage > 0 && targetPage <= pageCount) {
							window.open("${pageInfo.action }?currentPage="
									+ targetPage, "_self");
						}
					}
				})
	})
</script>
<table width="100%" border="0" align="center" cellpadding="0"
	cellspacing="0" class="right-font08">
	<tr>
		<td width="50%">共 <span class="right-text09" id="pageCount">${pageInfo.pageCount }</span>
			页 | 第 <span class="right-text09" id="currentPage">${pageInfo.currentPage }</span>
			页
		</td>
		<td width="49%" align="right">[<a
			href="${pageInfo.action }?currentPage=1" class="right-font08">首页</a>
			| <a
			href="${pageInfo.action }?currentPage=${pageInfo.currentPage-1 }"
			class="right-font08" id="lastPage">上一页</a> | <a
			href="${pageInfo.action }?currentPage=${pageInfo.currentPage+1 }"
			class="right-font08" id="nextPage">下一页</a> | <a
			href="${pageInfo.action }?currentPage=${pageInfo.pageCount }"
			class="right-font08">末页</a>] 转至：
		</td>
		<td width="1%"><table width="20" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="1%"><input name="textfield3" type="text"
						class="right-textfield03" size="1" id="targetPage" /></td>
					<td width="87%"><input name="Submit23222" type="button"
						class="right-button06" id="btn_sub" /></td>
				</tr>
			</table></td>
	</tr>
</table>