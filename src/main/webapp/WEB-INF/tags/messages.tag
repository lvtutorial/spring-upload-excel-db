<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="bean" required="true" rtexprvalue="true" type="com.hlv.bean.AbstractBean" description="MessageBean support binding"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="ext" %>
<div class="messages">
						<c:forEach items="${bean.messages}" var="message" >
							<div
								class="alert 
									${message.status=='error'?'alert-danger':''} 
									${message.status=='success'?'alert-success':''} 
									${message.status=='info'?'alert-info':''} 
									fade in">
								<button class="close" data-dismiss="alert" type="button">×</button>
								${message.message}
							</div>
							
						</c:forEach>
</div>