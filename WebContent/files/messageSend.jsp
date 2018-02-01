<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<script src="../js/jquery-1.9.1.min.js"></script>
<script>
	$(function(){
		$("#btn_send").click(function(){
			$("form").submit();
		})
		$("#btn_sendUp").click(function(){
			$("form").submit();
		})
		
		$("#txt_emps").click(function(){
			$("#div_emps").fadeIn();
		})
		$("#btn_close").click(function(){
			$("#div_emps").fadeOut();
		})
		$.getJSON("emp.do",{},function(data){
			var table=$("#tb_emps");
			var tr=null;
			for(var i=0;i<data.length;i++){
				if(i%3==0){
					tr=$("<tr>");
					table.append(tr);
				}
				var td=$("<td></td>");
				tr.append(td);
				var cb=$("<input type='checkbox' name='empId' />").val(data[i].empID);
				td.append(cb);
				
				cb.click(function(){
					var array=[];
					var c=$("input:checked");
					c.each(function(){
						array.push($(this).next().html());
					})
					$("#txt_emps").val(array.join(","));
				})
				var span=$("<span></span>").html(data[i].empName);
				td.append(span);
			}
		});
	})
</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="message.do" method="post" name="form" target="sypost" >
<div class="MainDiv">
	<div id="div_emps" style="position: absolute; left: 175px; background-color: gray; width: 400px; height: 250px; display: none; ">
		<div style="float: right">
			<input type="button" id="btn_close" value="关闭" />
		</div>
		<div style="clear: both">
			<table id="tb_emps" width="100%">
			
			</table>
		</div>
	</div>
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >新建信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="发送" class="button" id="btn_sendUp" />　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>新建信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    
					    
					  <tr>
					    <td nowrap align="right" width="11%">消息标题:</td>
					    <td width="27%"><input name='messageTitle' type="text" class="text" style="width:154px" value="" /></td>
				        	
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					    </tr>
					    
					    
					    
					  <tr>
					    <td width="11%" align="right" nowrap>接收者:</td>
					    <td colspan="3"><input name='txt32' type="text" class="text" style="width:450px;" size="20" value="" id="txt_emps" />
					      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="priority">
							<option selected="selected">==选择==</option>
							<option value=1>低级</option>
							<option value=2>中级</option>
							<option value=3>高级</option>
						</select></td>
					    </tr>
					  
					  <tr>
					    <td  width="11%" nowrap align="right">信息内容:</td>
					    <td colspan="3"><textarea name="messageContent" cols="100" rows="20"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button" name="Submit" value="发送" class="button" id="btn_send" />　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
