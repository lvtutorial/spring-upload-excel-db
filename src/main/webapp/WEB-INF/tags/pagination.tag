<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="bean" required="true" rtexprvalue="true" type="com.hlv.bean.AbstractBean" description="AbstractBean support binding"%>
<%@ attribute name="maxPage" rtexprvalue="true" type="java.lang.Integer" description="Max page to display" %>
<%@ attribute name="formId" rtexprvalue="true" type="java.lang.String" description="Form id to submit form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ext" %>
<div style="">
<c:if test="${empty  maxPage}">
	<c:set var="maxPage" value="10"></c:set> 
</c:if>
<script type="text/javascript">
	hiddenValToForm('${formId}',{'page':'${bean.page}','maxPage':'${maxPage}'});
</script>
<c:if test="${bean.total > bean.limit }">
	<ul class="pagination pagination-sm pull-right">
		<c:if test="${bean.page gt 1 }">
			<li><a href="javascript:submitAndSetHiddenVal('${formId}',{'page':'${bean.page-1 }','maxPage':'${maxPage}'})"><spring:message text="prev"></spring:message></a></li>
		</c:if>	
		<c:forEach var="i" items="${bean.listPage }">			
			<li class="${bean.page eq i?'active':'' }"><a href="javascript:submitAndSetHiddenVal('${formId}',{'page':'${i }','maxPage':'${maxPage}'})">${i }</a></li>
		</c:forEach>
		<c:if test="${bean.page < bean.totalPage }">
			<li><a href="javascript:submitAndSetHiddenVal('${formId}',{'page':'${bean.page+1 }','maxPage':'${maxPage}'})"><spring:message text="next"></spring:message></a></li>
		</c:if>
	</ul>
</c:if>
</div>
<div style="clear: both"></div>	
