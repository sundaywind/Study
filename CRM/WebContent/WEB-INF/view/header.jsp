<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/common.jsp"%>
<link href="/crm/static/css/styles.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<script type="text/javascript">
		/* $(function(){
			$("#logout").click(function(){
				window.parent.parent.location.href = this.href;
			});
		}) */
	</script>
  </head>
  <body style="border-bottom:solid 1px #666;">
	<TABLE style="width:100%;">
	<TR >
		<td ><img src="${ctxStatic}/images/logo.jpg"></td>
		<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
		<td width="25%" align="right" style="font-size:12px;" valign="bottom">
			<b>当前登录用户:</b> <shiro:principal/> [<a href="${ctx}/logout" id="logout">注销</a>]&nbsp;&nbsp;<br />
		 </td>
	</tr>
	</table>
  </body>
</html>
