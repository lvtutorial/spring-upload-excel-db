<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="url" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE HTML>
<!-- use code below will conflict with button search btn btn-default of bootstrap -->
<!-- DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<!-- https://developers.google.com/chart/interactive/docs/gallery -->
<!-- https://developers.google.com/chart or http://www.chartjs.org or https://www.highcharts.com-->
<!-- online chart google -->
<!-- google.loader.ServiceBase = 'https://www.google.com/uds';
	 google.loader.GoogleApisBase = 'https://ajax.googleapis.com/ajax'; -->

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="${url}/resources/img/favicon.ico" />

<link href="${url}/resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${url}/resources/css/bootstrap-theme.min.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css" href="${url}/resources/css/itsSpring.css"/>
<link rel="stylesheet" type="text/css" href="${url}/resources/css/flip-scroll.css"/>
<link rel="stylesheet" type="text/css" href="${url}/resources/css/signin.css"/>
<link rel="stylesheet" type="text/css" href="${url}/resources/css/menu.css"/>
<!-- angularjs for users_angularjs -->
<!--  
<script src="${url}/resources/js/angular-1.5.3.min.js"></script>
<script src="${url}/resources/js/angular-animate-1.5.3.min.js"></script>
<script src="${url}/resources/js/ui-bootstrap-tpls-1.3.3.min.js"></script>
<script src="${url}/resources/js/angularjs-modal.js"></script>
-->
<!-- jquery -->
<script src="${url}/resources/js/jquery.min.js"></script>
<!-- <script src="${url}/resources/js/jquery.maskMoney.min.js"></script>  -->
<script src="${url}/resources/js/jquery.inputmask.min.js"></script>
<script src="${url}/resources/js/bootstrap.min.js"></script>

<!-- boot -->
<script src="${url}/resources/js/bootbox.min.js"></script>

<!-- cron expression -->
<!-- <link rel="stylesheet" type="text/css" href="${url}/resources/css/jquery-cron.css"/>
<script src="${url}/resources/js/jquery-cron-min.js"></script> -->


<!-- jqcron expression -->
<link rel="stylesheet" type="text/css" href="${url}/resources/css/jqdemo.css"/>
<link rel="stylesheet" type="text/css" href="${url}/resources/css/jqreset.css"/>
<link rel="stylesheet" type="text/css" href="${url}/resources/css/jqCron.css"/>
<script src="${url}/resources/js/jqCron.js"></script>
<script src="${url}/resources/js/jqCron.en.js"></script>

<!-- its system -->
<script src="${url}/resources/js/its.js"></script>



<!--
<script src="js/jquery-1.9.1.min.js"></script>
 -->
<title><dec:title default="Web Page" /></title>
<dec:head />
</head>
<body>
<div>    
    <div>            
    	<%@ include file="menu-top.jsp"%>  
    </div>
    <!-- /top menu -->
   <%-- <div id="m_header">            
    	<%@ include file="header.jsp"%>  
    </div>  --%>     		    
    <!-- /header -->
    <div class="container">
         <dec:body />
    </div>    
    <!-- /main -->
    <div id="m_footer">
		<%@ include file="footer.jsp"%>
    </div>
    <!-- /footer -->
</div>    
</body>
</html>