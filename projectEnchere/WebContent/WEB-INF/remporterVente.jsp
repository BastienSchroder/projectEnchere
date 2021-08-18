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
<title>Remporter vente</title>
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
Utilisateur dernierEncherisseur = (Utilisateur) request.getAttribute("dernierEncherisseur");
%>
<form action="<%= request.getContextPath()%>/encherir" method="POST">
	<div class="row body">
 		<div class="container">
			<div class=" row box-shadow margin-div">
				<h2 class="text-center h2">Vous avez remporté la vente</h2>
				<input type="hidden" name="noArticle" value="<%= article.getNoArticle() %>">
				
					<div class="col-4">
						<img src="..." srcset="https://images.unsplash.com/photo-1503602642458-232111445657?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1834&q=80" class="img-fluid" alt="...">
					</div>
					<div class="col-6">
						<h3 class="mb-3"><%= article.getNomArticle() %></h3>
						<p><b>Description du produit : </b>
						<%= article.getDescription() %></p>
						<p class="mb-3"><b>Meilleure offre : </b>
						<%= enchere.getMontantEnchere() %> points</p>
						<p class="mb-3"><b>Mise à prix : </b>
						<%= article.getPrixInitiale() %> points</p>
						<p class="mb-3"><b>Retrait : </b>
						<%= retrait.getRue() %> <br><%= retrait.getCodePostal() + "-" + retrait.getVille()%> </p>
						<p class="mb-3"><b>Vendeur : </b>
						<%= utilisateur.getPseudo() %> </p>
						<p class="mb-3"><b>Téléphone : </b>
						<%= utilisateur.getTelephone() %> </p>
						<label>Crédits : <%= utilisateur.getCredit() %></label>	
				</div>				
			</div>
		</div>
	</div>	
</form>
<div>
<form action="<%= request.getContextPath()%>/retrait" method="POST">
<input type="submit" name="retrait" value="Retrait">
<input type="hidden" name="noArticle" value="<%= article.getNoArticle() %>">
</form>
</div>

</body>
</html>