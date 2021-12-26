<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title> VIKASH </title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta content="" name="description">
    <meta content="" name="author">
    <!-- App favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
   <script src="/scripts/script.js"></script> 
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   
   <script src="//code.jquery.com/jquery.min.js"></script>

<link rel="stylesheet" href="jquery.dropdown.css">

<script src="jquery.dropdown.js"></script>
   
   
   <!-- datatable -->
    <link href="${pageContext.request.contextPath}/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
     <link href="${pageContext.request.contextPath}/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css">
    
    
    <!--    <link href="assets/plugins/jvectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet"> -->
    <link href="${pageContext.request.contextPath}/css/plugins/slick/slick.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/plugins/slick/slick-theme.css" rel="stylesheet" type="text/css">
     <link href="${pageContext.request.contextPath}/css/fontawesome.css" rel="stylesheet" type="text/css">
  
    <!-- App css -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/icons.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/metismenu.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>



	 <div id="wrapper">
        <!-- Topbar Start -->
        
	 	<tiles:insertAttribute name="header" />
	 	
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
        
    
        <%-- <div class="content-page">
            
            	<tiles:insertAttribute name="body" />
            
            	<tiles:insertAttribute name="footer" />
            	
        </div> --%>
        
    </div>
	
			<!-- Page Content-->
				 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
			
			<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
		    <script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
		    <script src="${pageContext.request.contextPath}/js/waves.min.js"></script>
		    <script src="${pageContext.request.contextPath}/js/jquery.slimscroll.js"></script>
		    
		    <script src="${pageContext.request.contextPath}/js/bootstrap-multiselect.js"></script>
		       <%-- <script src="${pageContext.request.contextPath}/js/form_multiselect.js"></script> --%>
		
		    <script src="${pageContext.request.contextPath}/js/plugins/slick/slick.min.js"></script>
		    <script src="${pageContext.request.contextPath}/js/plugins/slick/jquery.slick.init.js"></script>
		
		    <script src="${pageContext.request.contextPath}/js/autoscroll.js"></script>
		    <!-- App js -->
		   
	        
	         <script src="${pageContext.request.contextPath}/js/app.js"></script>
	          <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
	        <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
	        <script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap4.min.js"></script>
	        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
           
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
   			 <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
   	
   	
   	
   	
   	<script type="text/Javascript" src="${pageContext.request.contextPath}/configJs/configVariables.js"></script>
      <script type="text/Javascript" src="${pageContext.request.contextPath}/configJs/configFunction.js"></script>
	 <script type="text/Javascript" src="${pageContext.request.contextPath}/ajaxJs/configAjax.js"></script>
	 
</body>

</html>