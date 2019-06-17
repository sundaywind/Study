<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>销售机会管理</title>
	<script type="text/javascript">
		$(function(){
			$("#new").click(function(){
				window.location.href="${ctx}" + "/chance/create";
				return false;
			});
		})
	</script>
	<script type="text/javascript">
		/*  
			1）写jQuery函数上来先写个：
				$(function(){
					
				});
			2）给img标签name属性值为delete的 添加一个点击事件
			3）获取name属性为delete的当前id属性的值。
		*/
		$(function(){									// 1）
			$("img[name=delete]").click(function(){		// 2）
				var requestUrl = $(this).attr("id");	// 3）
				// alert(requestUrl);
				var form = $("form")[0];
				$("#dd").attr("value", "delete");	// 将id为dd的的value属性 设置为delete
				$(form).attr("action", requestUrl).submit();	// 将第一个form表单的action属性 设置为requestUrl
			});
		});
	</script>
	
	<!-- 
		去超链接下划线 ：
		    a:link 指正常的未被访问过的链接；
		　　  a:active 指正在点的链接；
		　　  a:hover 指鼠标在链接上；
		　　  a:visited 指已经访问过的链接；
		　　  text-decoration是文字修饰效果的意思；
		　　  none参数表示超链接文字不显示下划线；
		　  　underline参数表示超链接的文字有下划线
	-->
	<style type="text/css">
		a {text-decoration: none}
		a:link { text-decoration: none;color: blue}
	　　 a:active { text-decoration:blink}
	　　 a:hover { text-decoration:underline;color: red}
	　　 a:visited { text-decoration: none;color: green}
	</style>
</head>

<body class="main">
	<!-- form表单的作用只是用来提交数据 -->
	<form action="#" method="post">
		<input id="dd" type="hidden" name="_method" value=""/>
	</form>
	<form id="command" action="${ctx}/chance/list" method="post">
		<div class="page_title">
			销售机会管理
		</div>
		<div class="button_bar">
			<button class="common_button" id="new">
				新建
			</button>
			<button class="common_button" onclick="document.forms[0].submit();">
				查询
			</button>
		</div>
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th class="input_title">
					客户名称
				</th>
				<td class="input_content">
					<input type="text" name="search_LIKE_custName" />
				</td>
				<th class="input_title">
					概要
				</th>
				<td class="input_content">
					<input type="text" name="search_LIKE_title" />
				</td>
				<th class="input_title">
					联系人
				</th>
				<td class="input_content">
					<input type="text" name="search_LIKE_contact" />
				</td>
			</tr>
		</table>
	</form>
		<%-- <sys:message content="${message}"/> --%>
		${message}
		<!-- 列表数据 -->
		<br />
			<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
				<tr>
					<th>
						编号
					</th>
					<th>
						客户名称
					</th>
					<th>
						概要
					</th>
					<th>
						联系人
					</th>
					<th>
						联系人电话
					</th>
					<th>
						创建时间
					</th>
					<th>
						操作
					</th>
				</tr>
				
				<c:forEach items="${page.list }" var="salechance">
					<tr>
						<td class="list_data_number">${salechance.id }</td>
						<td class="list_data_text">${salechance.custName }</td>
						<td class="list_data_text">${salechance.title }</td>
						<td class="list_data_text">${salechance.contact }</td>
						<td class="list_data_text">${salechance.contactTel }</td>
						<td class="list_data_text">
							<!-- format格式化标签库，格式化时间格式 -->
							<fmt:formatDate value="${salechance.createDate }" pattern="yyyy-MM-dd hh:mm:ss"/>
						</td>
						<td class="list_data_op">
							<img onclick="window.location.href='${ctx}/chance/dispatch?id=${salechance.id }'" title="指派" src="${ctxStatic}/images/bt_linkman.gif" class="op_button" />
							<img onclick="window.location.href='${ctx}/chance/create?id=${salechance.id }'" title="编辑" src="${ctxStatic}/images/bt_edit.gif" class="op_button" />
							<img name="delete" id="${ctx}/chance/delete?id=${salechance.id }" title="删除" src="${ctxStatic}/images/bt_del.gif" class="op_button" />
						</td>
					</tr>
				</c:forEach>
			</table>
<%@ include file="/WEB-INF/page/page.jsp" %>	
</body>
</html>