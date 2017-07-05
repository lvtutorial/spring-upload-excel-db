	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	   	  <a class="navbar-brand" href="${url}/home"><span class="glyphicon glyphicon-home"></span></a>	   	  
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    <ul class="nav navbar-nav">  	  	  
		   	 	  <li class="dropdown">
			        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
			        <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="${url}/upload">Upload</a></li>   
			          <li><a href="${url}/page-2">Page-2</a></li> 
			        </ul>
			      </li>  				              			      		    
		      
		    </ul>	
		    <p class="navbar-text navbar-right">
		    	lvtutorial - <span class="glyphicon glyphicon-user"></span> <a class="navbar-link" href=<c:url value="/j_spring_security_logout"/>>Logout</a>
		    </p>
		</div>    	
	  </div><!-- /.container-fluid -->
	</nav>

<script>
	//get active page to set class active for highlight current menu
	$(function(){
	  function stripTrailingSlash(str) {
	    if(str.substr(-1) == '/') {
	      return str.substr(0, str.length - 1);
	    }	    
	    return str;	    
	  }

	  var url = window.location.pathname;  
	  var activePage = stripTrailingSlash(url);
	  //console.log("url: " + url);

	  //dropdown
	  $('.nav .dropdown li a').each(function(){  
	    var currentPage = stripTrailingSlash($(this).attr('href'));	  	
	    if (activePage == currentPage) {
	      $(this).parent().parent().parent().addClass('active'); 
	    } 
	  });

	  //child menu 
	  $('.nav li a').each(function(){  
	    var currentPage = stripTrailingSlash($(this).attr('href'));	    
	    if (activePage == currentPage) {	      
	      $(this).parent().addClass('active'); 
	    } 
	  });
	});
</script>



