<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/commons/common.jsp"%>
<title>客户关系管理系统</title>
<!--  
	frameset标签（框架）：
		1）与body标签不能共存，只能有一个存在。
		frameset标签可以嵌套frame标签，也可以嵌套frameset。
		rows：（rows="85,*,40"  ： 意思将页面分为 上中下 3部分）
-->
<frameset rows="85,*,40" frameborder="NO" noresize Borders="NO" framespacing="0">	
	<frame name="topFrame" src="${ctx}/header" frameborder="NO" scrolling="NO" noresize Borders="NO" marginwidth="value" marginheight="value">
		<frameset rows="*" cols="180,*" border="0" noresize framespacing="2">
			<frame name="menu" src="${ctx}/menu" border="0" scrolling="auto" marginwidth="0" leftmargin="0" marginheight="0" APPLICATION="yes">
			<frame id="content" name="content" src="${ctx}/welcome" frameborder="no" marginwidth="0" marginheight="0" APPLICATION="yes">
		</frameset>
	<frame src="${ctx}/footer" name="#" frameborder="NO" scrolling="NO" noresize marginwidth="0" marginheight="0" Borders="NO">	
</frameset>