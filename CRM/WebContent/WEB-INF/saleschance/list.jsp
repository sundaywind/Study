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
</head>

<body class="main">
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
	<%-- 共 ${page.totalRecord } 条记录 
	&nbsp;&nbsp;
	当前第 ${page.pageNo } 页/共 ${page.totalNumber } 页
	&nbsp;&nbsp;
		<a href='?page=2&sortType=&&'>下一页</a>
		&nbsp;&nbsp;
		<a href='?page=2&sortType=&&'>末页</a>
		&nbsp;&nbsp;
	转到 <input id="pageNo" size='1'/> 页
	&nbsp;&nbsp; --%>
	<a href="/CRM/saleschance/list?pageNo=1">首页</a>
	&nbsp;&nbsp;
	<a href="/CRM/saleschance/list?pageNo=${page.pageNo + 1}">下一页</a>
	&nbsp;&nbsp;
	
	<c:choose>
		<c:when test="${page.totalNumber <= 5}">
			<!-- c:set标签可以把value里面的值附给var的变量并放入Scott域中 -->
			<c:set var="begin" value="1"></c:set>
			<c:set var = "end" value="${page.totalNumber}"></c:set>
		</c:when>
		<c:when test="${page.totalNumber <= 3}">
			<c:set var="begin" value="1"></c:set>
			<c:set var = "end" value="5"></c:set>
		</c:when>
		<c:when test="${page.totalNumber > 3}">
			<c:set var="begin" value="${page.pageNo - 2}"></c:set>
			<c:set var = "end" value="${page.pageNo + 2}"></c:set>
			<c:if test="${end > page.totalNumber}">
				<c:set var="begin" value="${end - 4}"></c:set>
				<c:set var = "end" value="${page.totalNumber}"></c:set>
			</c:if>
		</c:when>
	</c:choose>
	<script type="text/javascript">
		alert("${begin}");
	</script>
	
	<c:forEach begin="${begin}" end="${end}" var="index">
		<c:if test="${page.pageNo == index}">
			<a href="/CRM/saleschance/list?pageNo=${index}"><font color="red">【${index}】</font></a>
			&nbsp;&nbsp;
		</c:if>
		<c:if test="${page.pageNo != index}">
			<a href="/CRM/saleschance/list?pageNo=${index}">${index}</a>
			&nbsp;&nbsp;
		</c:if>
	</c:forEach>
	
	<a href="/CRM/saleschance/list?pageNo=${page.pageNo - 1}">上一页</a>
	&nbsp;&nbsp;
	<a href="/CRM/saleschance/list?pageNo=${page.totalNumber}">末页</a>
</div>
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
	</form>
	
</body>
</html>