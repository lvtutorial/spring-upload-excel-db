<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="ext" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Upload Excel to DB</title>
<style>
	.btn-browser{padding: 6px 0;}
</style>
</head>
<body>

<div class="ita_form">
	
	<ext:messages bean="${bean}"></ext:messages>
	<c:url var="addAction2003" value="/upload/2003"></c:url>
	<c:url var="addAction2007" value="/upload/2007"></c:url>

	<form:form action="${addAction2003}" method="post" enctype="multipart/form-data" commandName="bean">
		<div class="panel panel-default">
	    	<div class="panel-heading">
				<div class="label_title">Upload Excel 2003 to DB</div>
	    	</div>
	      	<div class="panel-body">	      
	      		<div class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-2">Import Data</label>
						<div class="col-sm-6">
							<input name="excelfile" type="file" class="btn btn-browser">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button type="submit" class="btn btn-primary" id="saveEdit">
								<span class="glyphicon glyphicon-floppy-disk"></span> <spring:message text="Save" />
							</button>					
							<a href="<c:url value='/upload' />" class="btn btn-primary">
								<span class="glyphicon glyphicon-off"></span> <spring:message code="btn.close" />
							</a>
						</div>	
					</div>
	      		</div>
	      	</div>
	    </div>	    
	
	</form:form>
	
	<form:form action="${addAction2007}" method="post" enctype="multipart/form-data" commandName="bean">
		<div class="panel panel-default">
	    	<div class="panel-heading">
				<div class="label_title">Upload Excel 2007 to DB</div>
	    	</div>
	      	<div class="panel-body">	      
	      		<div class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-2">Import Data</label>
						<div class="col-sm-6">
							<input name="excelfile2007" type="file" class="btn btn-browser">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button type="submit" class="btn btn-primary" id="saveEdit">
								<span class="glyphicon glyphicon-floppy-disk"></span> <spring:message text="Save" />
							</button>					
							<a href="<c:url value='/upload' />" class="btn btn-primary">
								<span class="glyphicon glyphicon-off"></span> <spring:message code="btn.close" />
							</a>
						</div>	
					</div>
	      		</div>
	      	</div>
	    </div>	    
	
	</form:form>

</div>
</body>
</html>