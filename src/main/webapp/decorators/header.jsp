<sec:authorize access="isAuthenticated()">
	<!-- ${pageContext.request.userPrincipal.name} -->
	<div>
		Welcome: ${sessionScope['scopedTarget.userProfile'].user.fullname} - <span class="glyphicon glyphicon-user"></span> <a href=<c:url value="/j_spring_security_logout"/>>Logout</a>
		<span style="float: right">
<%-- 			Current Locale : ${pageContext.response.locale} --%>
<!-- 			&nbsp;&nbsp; -->
<!-- 			<a href="?lang=en">en</a>  -->
<!-- 			|  -->
<!-- 			<a href="?lang=vi">vi</a> -->
<!-- 			&nbsp;&nbsp; -->
		</span>
		
	</div>
</sec:authorize>			
	
	