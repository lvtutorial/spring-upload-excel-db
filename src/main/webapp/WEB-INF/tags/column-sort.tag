<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ attribute name="bean" required="true" rtexprvalue="true" type="vn.com.unit.bms.bean.AbstractBean" description="AbstractBean support binding sort"%>
<%@ attribute name="path" required="true" rtexprvalue="true" type="java.lang.String" description="path to sort"%>
<%@ attribute name="fieldName" required="true" rtexprvalue="true" type="java.lang.String" description="title to display column name" %>
<%@ attribute name="formId" required="true" rtexprvalue="true" type="java.lang.String" description="Form search id" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ext" %>
					<spring:url value="" var="sort">
				        <spring:param name="dir" value="${path}" />
				        <spring:param name="sort" value="${bean.sort=='desc'?'asc':'desc' }" />
			     	</spring:url>
			     	<c:if test="${bean.dir eq path}">
			     	<script type="text/javascript">
			     		hiddenValToForm('${formId}',{'dir':'${bean.dir}','sort':'${bean.sort}'});
			     	</script>
			     	</c:if>
				<a href="javascript:submitAndSetHiddenVal('${formId}',{'dir':'${path}','sort':'${bean.sort=='desc'?'asc':'desc' }'})" style="color: #fff;">${fieldName } 
				<c:if test="${bean.sort=='desc' and bean.dir==path}">
					<i class="icon-arrow-up"></i>
				</c:if>
				<c:if test="${bean.sort=='asc' and bean.dir==path }">
					<i class="icon-arrow-down"></i>
				</c:if>
				</a>