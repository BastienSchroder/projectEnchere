<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.ArrayList" %>
    <%@page import="bo.Categorie"%>
    <%@page import="java.awt.TextArea"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
 <%@include file="../require/head.jsp" %>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <link href='https://fonts.googleapis.com/css?family=Amethysta' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Caesar+Dressing' rel='stylesheet' type='text/css'>
</head>
<body class="admin-body">
<% StringBuilder ta = (StringBuilder)request.getAttribute("textArea"); 
System.out.println(ta);%>
<div class="row ">
<div class="col-2 ">
		 <%@include file="../require/adminHeader.jsp" %>
	</div>
	<div class="col-8 mrg-left ">
	
	<h1 class=testfeu> <span class="span-ish fire">L</span>
	<span class="span-ish burn">e</span>
	<span class="span-ish fire">s</span> 
	<span class="span-ish burn">-</span>
	 <span class=" span-ish fire">L</span>
	 <span class="span-ish burn">o</span>
	 <span class=" span-ish fire">g</span>
	 <span class="span-ish burn">s</span>
	 <span class="span-ish fire">-</span>  
	 <span class="span-ish burn">D</span>
	 <span class="span-ish fire">e</span>
	 <span class="span-ish burn">s</span>
	 <span class="span-ish fire">-</span>  
	 <span class="span-ish burn">E</span>
	 <span class="span-ish fire">n</span>
	 <span class="span-ish burn">f</span>
	 <span class="span-ish fire">e</span>
	 <span class="span-ish burn">r</span>
	 <span class="span-ish fire">s</span></h1>
	
	<textarea class="enfer" spellcheck="false" id="story" name="story"
          rows="30" cols="200">
	<%= ta%>	
	</textarea>
</div>
</div>

<script>
setTimeout(function(){
    window.location.reload();
},5000);
</script>
</body>
</html>