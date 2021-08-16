<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bo.ArticleVendu" %>
<%@ page import="bo.Enchere" %>
<%@ page import="bo.Categorie" %>
<%@ page import="bo.Retrait" %>
<%@ page import="bo.Utilisateur" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail vente</title>
<%@include file="require/head.jsp" %>

</head>
<body>
<%@include file="require/header.jsp" %>
<%
ArticleVendu article = (ArticleVendu)request.getAttribute("article");
Enchere enchere = (Enchere)request.getAttribute("detailEnchere");
Categorie categorie = (Categorie) request.getAttribute("categorie");
Retrait retrait = (Retrait) request.getAttribute("retrait");
Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>
<div class="row body">
	<h2 class="text-center mb-5 list-title h1">Détail vente</h2>
	<div class="container">
		<div class=" row box-shadow margin-div">
			
				<div class="col-4">
					<img src="..." srcset="https://images.unsplash.com/photo-1503602642458-232111445657?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1834&q=80" class="img-fluid" alt="...">
				</div>
				<div class="col-6">
					<h3 class="mb-3"><%= article.getNomArticle() %></h3>
					<p><b>Description du produit : </b></p>
					<p><%= article.getDescription() %>
					</p class="mb-3"><b>Catégorie : </b>
					<p><%= categorie.getLibelle() %></p>
					</p class="mb-3"><b>Meilleure offre : </b>
					<p><%= enchere.getMontantEnchere() %></p>
					</p class="mb-3"><b>Mise à prix : </b>
					<p><%= article.getPrixInitiale() %></p>
					</p class="mb-3"><b>Fin de l'enchère : </b>
					<p><%= article.getDateFinEncheres() %></p>
					</p class="mb-3"><b>Retrait : </b>
					<p><%= retrait.getRue() %> <br><%= retrait.getCodePostal() + "-" + retrait.getVille()%> </p>
					<p class="mb-3"><b>Vendeur : </b></p>
					<p><%= utilisateur.getPseudo() %> </p>
		
					<form>
						<label for="encherir" class="m"><b>Ma proposition : </b></label>
						<div class="input-group mb-3">
		  					<input type="number" class="form-control"  value="<%=enchere.getMontantEnchere() %>" aria-label="Recipient's username" aria-describedby="button-addon2">
		  					<button class="btn btn-outline-success" type="button" id="button-addon2">Enchérir</button>
						</div>
					</form>
			
		</div>
	</div>
</div>	

</body>
</html>