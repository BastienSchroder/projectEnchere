<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bo.ArticleVendu" %>
<%@ page import="bo.Enchere" %>
<%@ page import="bo.Categorie" %>
<%@ page import="bo.Retrait" %>
<%@ page import="bo.Utilisateur" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier vente</title>
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
ArrayList<Categorie> listeCategories = (ArrayList<Categorie>)request.getAttribute("listeCategories");
%>
<form action="<%= request.getContextPath()%>/encherir" method="POST">
	<div class="row body">
		<h2 class="text-center mb-5 list-title h1">Détail vente</h2>
		<div class="container">
			<div class=" row box-shadow margin-div">
				<input type="hidden" name="noArticle" value="<%= article.getNoArticle() %>">
				
					<div class="col-4">
						<img src="..." srcset="https://images.unsplash.com/photo-1503602642458-232111445657?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1834&q=80" class="img-fluid" alt="...">
					</div>
					<div class="col-6">
						<h3 class="mb-3"><%= article.getNomArticle() %></h3>
						<p><b>Description du produit : </b></p>
						<input type="text" name="description" value="<%= article.getDescription() %>">
						</p class="mb-3"><b>Catégorie : </b>
				<select id="selectCategorie" name="selectCategorie" class="form-select" >
			  		<option selected><%= categorie.getLibelle() %></option>
			  			<%
			  			for(Categorie c1 : listeCategories){
			  				if(!c1.getLibelle().equals(categorie.getLibelle())){
			  					%>
			  					<option value="<%= c1.getNoCategorie()%>"><%= c1.getLibelle()%></option>
			  			<%
			  			}}
			  			%>
				</select>
						</p class="mb-3"><b>Meilleure offre : </b>
						<input type="text" name="meilleureOffre" value="<%=  enchere.getMontantEnchere()  %>">
						</p class="mb-3"><b>Mise à prix : </b>
						<input type="text" name="miseAPrix" value="<%=   article.getPrixInitiale()  %>">
						</p class="mb-3"><b>Fin de l'enchère : </b>
						<input type="date" class="datepicker" name="finEnchere"  value="<%=  article.getDateFinEncheres()%>">
						</p class="mb-3"><b>Retrait : </b>
						<input type="text" name="retraitRue" value="<%=  retrait.getRue()%>">
						<br>
						<input type="text" name="codePostal" value="<%= retrait.getCodePostal()%>">
						<input type="text" name="ville" value="<%= retrait.getVille()%>">
						<p class="mb-3"><b>Vendeur : </b></p>
						<p><%= utilisateur.getPseudo() %> </p>
			
			
							<label for="encherir" class="m"><b>Ma proposition : </b></label>
							<div class="input-group mb-3">
			  					<input name="montantEnchere" type="number" class="form-control"  value="<%=enchere.getMontantEnchere() %>" aria-label="Recipient's username" aria-describedby="button-addon2"  <%= session.getAttribute("noUtilisateur").equals(utilisateur.getNoUtilisateur()) ? "disabled" : "" %> >
			  					<input type="submit" class="btn btn-outline-success"  id="button-addon2" value="Enchérir" <%= session.getAttribute("noUtilisateur").equals(utilisateur.getNoUtilisateur()) ? "disabled" : "" %>>
							</div>
							<input type="hidden" name="credit" value="<%= utilisateur.getCredit() %>">
							<label>Crédits : <%= utilisateur.getCredit() %></label>				
			</div>
		</div>
	</div>	
</form>
</body>
</html>