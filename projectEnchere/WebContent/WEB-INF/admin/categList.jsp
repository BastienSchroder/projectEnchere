<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="java.util.ArrayList" %>
    <%@page import="bo.Categorie"%>
    <%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
 <%@include file="../require/head.jsp" %>

</head>
<body class="admin-body">
<%ArrayList<Categorie> cl = (ArrayList<Categorie>)request.getAttribute("Categorie"); %>
<div class="row ">
<div class="col-2 ">
		 <%@include file="../require/adminHeader.jsp" %>
	</div>
	<div class="col-8 mrg-left ">
	<h1 class="h1-admin mt-3">Liste des catégories</h1>
	<a href="/projectEnchere/addcateg" class="btn btn-primary">Ajouter une catégorie</a>
			  
	<table class=" text-center mt-5 table table-dark table-striped">
		  <thead>
		    <tr>
		      <th scope="col">noCateg</th>
		      <th scope="col">Libelle</th>
		      <th scope="col">Supprimer</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <%for (int i = 0; i < cl.size(); i++) {
			  Categorie categ = cl.get(i);
			  		  %> <tr>
						      <td><%= categ.getNoCategorie()%></td>
						      <td><%= categ.getLibelle()%></td>
						      <td>
						      	<form action="<%= request.getContextPath()%>/categ" method="POST">
			  							<button type="submit"  name="categToDel" value="<%= categ.getNoCategorie()%>" class="btn btn-primary">Supprimer</button>	  
								</form>
							  </td>
						  </tr>
						  <%
			  		    
			  		}%> 		
		  </tbody>
	</table>
	</div>
	</div>
</body>
</html>