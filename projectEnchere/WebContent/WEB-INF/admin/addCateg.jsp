<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
 <%@include file="../require/head.jsp" %>
</head>
<body class="admin-body">
<div class="row ">
<div class="col-2 ">
		 <%@include file="../require/adminHeader.jsp" %>
	</div>
	<div class="col-8 mrg-left ">
	<h1 class="h1-admin mt-3">Ajouter une catégorie</h1>
	<form action="<%= request.getContextPath()%>/addcateg" method="POST">
	  <div class=" col-3 mb-3">
	    <label for="libelle" class="form-label">Libelle de la catérogie</label>
	    <input type="text" class="form-control" id="libelle" name="libelle">
	  </div>
	  
	  <button type="submit"  class="btn btn-primary">Ajouter</a>
	</form>
	</div>
</div>
	
</body>
</html>