<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="text-align:right; padding:6px 6px 0 0;">
	共 ${page.totalRecord } 条记录 
	&nbsp;&nbsp;
	当前第 ${page.pageNo } 页/共 ${page.totalNumber } 页
	&nbsp;&nbsp;
	转到 <input id="pageNo" size='1'/> 页
	&nbsp;&nbsp;
	
	<a href="${page.path}?pageNo=1${page.searchStr}">首页</a>
	&nbsp;&nbsp;
	<a href="${page.path}?pageNo=${page.pageNo + 1}${page.searchStr}">下一页</a>
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
			<a href="${page.path}?pageNo=${index}${page.searchStr}"><font color="red">【${index}】</font></a>
			&nbsp;&nbsp;
		</c:if>
		<c:if test="${page.pageNo != index}">
			<a href="${page.path}?pageNo=${index}${page.searchStr}">${index}</a>
			&nbsp;&nbsp;
		</c:if>
	</c:forEach>
	
	<a href="${page.path}?pageNo=${page.pageNo - 1}${page.searchStr}">上一页</a>
	&nbsp;&nbsp;
	<a href="${page.path}?pageNo=${page.totalNumber}${page.searchStr}">末页</a>
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
	What Fuck!
	JS中可以用Model中传过来的值，EL表达式取 但是要用引号包住！
-->
<input id="searchStr" type="hidden" value="${page.searchStr}"/>
<!-- 我写的JS跳转代码 -->
<script type="text/javascript">
	$(function(){
		$("#pageNo").change(function(){
			var searchStr = $("#page.searchStr").val();
			if (!searchStr) {
				searchStr = "";
			}
/* 			if (typeof(searchStr) == "undefined") {
				searchStr = "";
			} */
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
			window.location.href = "${page.path}?pageNo=" + pageNo + searchStr;	// 这样拼接的话会有问题，当serchStr为空的时候拼出来就是2undefined，所以前面要判断。
		})
	})
</script>