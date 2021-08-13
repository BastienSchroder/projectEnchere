<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bo.Utilisateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil</title>
 <%@include file="require/head.jsp" %>
</head>
<body>
<%@include file="require/header.jsp" %>
<%Utilisateur u1 = (Utilisateur)request.getAttribute("user1"); %>
<form action="<%= request.getContextPath()%>/profil" method="POST">
<div class="row body">
	<h2 class="text-center list-title h1">Profil</h2>
	<div class=" row box-shadow margin-div">
	<div  class="col text-center">
		<ul class="list-unstyled">
			  <li class="mb-2"><b>Pseudo :</b> <%= u1.getPseudo() %></li>
			  <li class="mb-2"><b>Nom :</b> <%= u1.getNom() %></li>
			  <li class="mb-2"><b>Prénom :</b> <%= u1.getPrenom() %> </li>
			  <li class="mb-2"><b>Email :</b><%= u1.getEmail() %></li>
			  <li class="mb-2"><b>Portable :</b> <%= u1.getTelephone() %></li>
			  <li class="mb-2"><b>Rue :</b> <%= u1.getRue() %></li>
			  <li class="mb-2"><b>Code postal :</b> <%= u1.getCodePostal() %></li>
			  <li class="mb-2"><b>Ville :</b> <%= u1.getVille()%></li>
		</ul>
	</div>
	
	<input type="submit" name="supprimer" class="btn btn-outline-secondary btn-lg" value="Supprimer compte">
	
</div>
</div>
</form>
</body>
</html>