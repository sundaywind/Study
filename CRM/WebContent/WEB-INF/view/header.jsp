<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<script type="text/javascript">
		/* 
			因为header.jsp是 主页面success.jsp的引用，如果是header.jsp去发请求 去删除session返回login.jsp只会返回头部那块，
			success.jsp其他页面的引用都不会返回，出现的尴尬就是 只有头部那块返回到login.jsp页面了。	
			我们要让这个请求由引用header.jsp的页面login.jsp来发，示例如下！
		*/
		$(function(){
			$("#logout").click(function(){
				window.parent.parent.location.href = this.href;
			});
		})
	</script>
  </head>
  <body style="border-bottom:solid 1px #666;">
	<TABLE style="width:100%;">
	<TR >
		<td ><img src="${ctxStatic}/images/logo.jpg"></td>
		<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
		<td width="25%" align="right" style="font-size:12px;" valign="bottom">
			<b>当前登录用户：${user.name}&nbsp;&nbsp;&nbsp;角色：${user.role.name }</b> <shiro:principal/> [<a href="${ctx}/logout" id="logout">注销</a>]&nbsp;&nbsp;<br />
		 </td>
	</tr>
	</table>
  </body>
</html>
