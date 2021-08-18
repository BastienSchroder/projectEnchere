<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.ArrayList" %>
    <%@page import="bo.Utilisateur"%>
    <%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
 <%@include file="../require/head.jsp" %>
</head>
<body class="admin-body">
<%ArrayList<Utilisateur> usr = (ArrayList<Utilisateur>)request.getAttribute("Utilisateur"); %>
<div class="row ">
	<div class="col-2 ">
		 <%@include file="../require/adminHeader.jsp" %>
	</div>
	<div class="col-8  mrg-left">
		<h1 class="h1-admin mt-3">Liste des utilisateurs</h1>
		<table class=" text-center mt-5 table table-dark table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Nom</th>
		      <th scope="col">Prénom</th>
		      <th scope="col">Pseudo</th>
		      <th scope="col">Supprimer</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <%for (int i = 0; i < usr.size(); i++) {
			   			Utilisateur user = usr.get(i);
			  		  %> <tr>
						      <td><%= user.getNom()%></td>
						      <td><%= user.getPrenom()%></td>
						      <td><%= user.getPseudo()%></td>
						      <td>
						      	<form action="<%= request.getContextPath()%>/admin" method="POST">
			  							<button type="submit"  name="usrToDel" value="<%= user.getNoUtilisateur()%>" class="btn btn-primary">Supprimer</button>	  
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