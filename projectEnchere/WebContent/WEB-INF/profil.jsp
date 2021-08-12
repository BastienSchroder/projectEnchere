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
<div class="row body">
	<h2 class="text-center list-title h1">Profil</h2>
	<div class=" row box-shadow margin-div">
	<div class="col text-center">
	<form action="<%= request.getContextPath()%>/profil" method="post">
		<ul class="list-unstyled">
			  <li class="mb-2"><b>Pseudo :</b> <input type="text" value="<%= u1.getPseudo() %>" name="pseudo"></li>
			  <li class="mb-2"><b>Nom :</b><input type="text" value="<%= u1.getNom() %>" name="nom"></li>
			  <li class="mb-2"><b>Prénom :</b><input type="text" value="<%= u1.getPrenom() %>" name="prenom"></li>
			  <li class="mb-2"><b>Email :</b><input type="text" value="<%= u1.getEmail() %>" name="email"></li>
			  <li class="mb-2"><b>Portable :</b><input type="text" value="<%= u1.getTelephone() %>" name="tel"></li>
			  <li class="mb-2"><b>Rue :</b><input type="text" value="<%= u1.getRue() %>" name="rue"></li>
			  <li class="mb-2"><b>Code postal :</b><input type="text" value="<%= u1.getCodePostal() %>" name="cp"></li>
			  <li class="mb-2"><b>Ville :</b><input type="text" value="<%= u1.getVille() %>" name="ville"></li>
			  <li class="mb-2"><b>Mot de passe :</b><input type="text" value="<%= u1.getMotDePasse() %>" name="mdp"></li>
		</ul>
		<button class="btn btn-primary" type="submit">Modifier</button>
	</form>
	</div>
	
	
</div>
</div>
</body>
</html>