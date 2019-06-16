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
				window.location.href="${ctx}" + "/saleschance/create";
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
	<form id="command" action="${ctx}/saleschance/list" method="post">
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
							<img onclick="window.location.href='${ctx}/saleschance/dispatch?id=${salechance.id }'" title="指派" src="${ctxStatic}/images/bt_linkman.gif" class="op_button" />
							<img onclick="window.location.href='${ctx}/saleschance/create?id=${salechance.id }'" title="编辑" src="${ctxStatic}/images/bt_edit.gif" class="op_button" />
							<img name="delete" id="${ctx}/saleschance/delete?id=${salechance.id }" title="删除" src="${ctxStatic}/images/bt_del.gif" class="op_button" />
						</td>
					</tr>
				</c:forEach>
			</table>
<div style="text-align:right; padding:6px 6px 0 0;">
	共 ${page.totalRecord } 条记录 
	&nbsp;&nbsp;
	当前第 ${page.pageNo } 页/共 ${page.totalNumber } 页
	&nbsp;&nbsp;
	转到 <input id="pageNo" size='1'/> 页
	&nbsp;&nbsp;
	
	<a href="/CRM/saleschance/list?pageNo=1${searchStr}">首页</a>
	&nbsp;&nbsp;
	<a href="/CRM/saleschance/list?pageNo=${page.pageNo + 1}${searchStr}">下一页</a>
	&nbsp;&nbsp;
	
	<!-- 这块好好理解一下 -->
	<c:choose>
		<c:when test="${page.totalNumber <= 5}">
			<!-- c:set标签可以把value里面的值附给var的变量并放入Scott域中 -->
			<c:set var="begin" value="1"></c:set>
			<c:set var = "end" value="${page.totalNumber}"></c:set>
		</c:when>
		<c:when test="${page.pageNo <= 3}">
			<c:set var="begin" value="1"></c:set>
			<c:set var = "end" value="5"></c:set>
		</c:when>
		<c:when test="${page.pageNo > 3}">
			<c:set var="begin" value="${page.pageNo - 2}"></c:set>
			<c:set var = "end" value="${page.pageNo + 2}"></c:set>
			<c:if test="${end > page.totalNumber}">
				<c:set var = "end" value="${page.totalNumber}"></c:set>
				<c:set var="begin" value="${end - 4}"></c:set>
			</c:if>
		</c:when>
	</c:choose>
	
	<c:forEach begin="${begin }" end="${end}" var="index">
		<c:if test="${page.pageNo == index}">
			<a href="/CRM/saleschance/list?pageNo=${index}${searchStr}"><font color="red">【${index}】</font></a>
			&nbsp;&nbsp;
		</c:if>
		<c:if test="${page.pageNo != index}">
			<a href="/CRM/saleschance/list?pageNo=${index}${searchStr}">${index}</a>
			&nbsp;&nbsp;
		</c:if>
	</c:forEach>
	
	<a href="/CRM/saleschance/list?pageNo=${page.pageNo - 1}${searchStr}">上一页</a>
	&nbsp;&nbsp;
	<a href="/CRM/saleschance/list?pageNo=${page.totalNumber}${searchStr}">末页</a>
</div>

<!-- 
	原项目JS跳转代码 ：
		1）pageNo用正整数正则验证，如果不是 直接return下面就不走了 打住。
		2）输入的是字符串 转int，如果小于1则return。
-->
<%-- <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#pageNo").change(function(){
			var pageNo = $(this).val();
			var reg = /^\d+$/;
			if(!reg.test(pageNo)){
				$(this).val("");
				alert("输入的页码不合法");
				return;
			}
			var pageNo2 = parseInt(pageNo);
			if(pageNo2 < 1 || pageNo2 > parseInt("2")){
				$(this).val("");
				alert("输入的页码不合法");
				return;
			}
			//查询条件需要放入到 class='condition' 的隐藏域中. 
			window.location.href = window.location.pathname + "?page=" + pageNo2 + "&sortType=&&";
		});
	})
</script> --%>

<!--  
	JavaScript只能取得页面上的值。
	在JS中不能使用EL表达式取Controller的Model中的值，我们可以用隐藏域的方式取。
-->
<input id="searchStr" type="hidden" value="${searchStr}"/>
<!-- 我写的JS跳转代码 -->
<script type="text/javascript">
	$(function(){
		$("#pageNo").change(function(){
			var searchStr = $("#searchStr").val();
			/* 1.获取pageNo中的值 */
			var pageNo = $("#pageNo").val();
			/* 2.正整数正则 */
			var reg = /^[1-9]\d*$/;
			/* 3.用正则验证 */
			var verify = reg.test(pageNo);
			if (!verify) {	// 如果验证为true 取反 跳过if，如果验证是false 取反则会进if判断。
				alert("您输入的有误！");
				return ;
			};
			window.location.href = "/CRM/saleschance/list?pageNo=" + pageNo + searchStr;
		})
	})
</script>
	
</body>
</html>