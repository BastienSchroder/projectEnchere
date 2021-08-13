<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="bo.Utilisateur"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@include file="require/head.jsp" %>
	  <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="./vendor/css/styles.css">
</head>

<body>

<%@include file="require/header.jsp" %>
<div class="row body">
	<h2 class="text-center list-title h1">Profil</h2>
	<div class=" row box-shadow margin-div">
	<div class="d-flex justify-content-center align-items-center container" >

	<div class="d-flex justify-content-center align-items-center container" style="margin-top:280px;">

	<form action="<%= request.getContextPath()%>/connexion" method="POST" >
	<div class="row">
		<div class="mb-3">
		    <label for="inputIdentifiant" class="form-label">Identifiant :</label>
		    <input type="text" id="inputIdentifiant" name="identifiant" class="form-control" required>
		</div>

		<div class="mb-3">
			    <label for="inputMotDePasse" class="form-label">Mot de passe :</label>
			    <input type="password" id="inputMotDePasse" name="mdp" class="form-control" required>
		</div>
	</div>
		<div class="row mb-5">
				<div id="connexion" class="col-4">
					<input type="submit" name="btnConnexion" value="Connexion" class="btn btn btn-primary">
				</div>
			
				<div class="col-7" id="contentMdp">
					<div>
						<input type="checkbox" class="form-check-input" id="seSouvenir" name="seSouvenir">
		    			<label class="form-check-label" for="seSouvenir">Se souvenir de moi</label>
					</div>
		    		<a href="">Mot de passe oublié</a>
		  		</div>
		</div>

		<div>
			<input type="submit" name="creerCompte" class="btn btn-outline-secondary btn-lg" value="Créer un compte">
		</div>
	</form>
</div>
</div>
</div>
</body>
</html>