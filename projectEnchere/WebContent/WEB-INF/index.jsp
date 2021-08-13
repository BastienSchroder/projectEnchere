<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="bo.Categorie"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-Enchère</title>
 <%@include file="require/head.jsp" %>
</head>
<body>

 <%@include file="require/header.jsp" %>
 <%ArrayList<Categorie> cl = (ArrayList<Categorie>)request.getAttribute("Categorie"); %>
<div class="row body">
	<h2 class="text-center list-title h1">Liste des enchères</h2>
	<div class=" row box-shadow margin-div">
	
		<div class="row">
			<h2>Filtres : </h2>
			<form class="d-flex col-6 col-sm-3 " action="<%= request.getContextPath()%>/accueil" method="POST">
			      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<br/>
		<form action="<%= request.getContextPath()%>/accueil" method="POST">
		<div class="row  mt-3">
			<div class="col-6 col-sm-1">
				<p>Catégorie </p>
			</div>
			<div class="col-6 col-sm-3">
				<select class="form-select" aria-label="Default select example">
			  		<option selected>-- Catégorie --</option>
			  		<%for (int i = 0; i < cl.size(); i++) {
			  		    Categorie categ = cl.get(i);
			  		  %><option value="<%= categ.getLibelle()%>"><%= categ.getLibelle()%></option><%
			  		    
			  		}%> 
				</select>
			</div>
			
		</div>
		<div class="row">
			<div class="col">
				<div class="form-check ">
					  <input class="form-check-input" type="checkbox" value="" id="achat">
					  <label class="form-check-label" for="achat">
					    Achats
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="bidOpen" id="bidOpen" disabled>
					  <label class="form-check-label" for="bidOpen">
					    Enchères ouvertes
					  </label>
				</div>
				<div class="form-check margin-check">	  
					  <input class="form-check-input" type="checkbox" value="bidInProgress" id="bidInProgress" disabled>
					  <label class="form-check-label" for="bidInProgress">
					    Mes enchères en cours
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="bidWon" id="bidWon" disabled>
					  <label class="form-check-label" for="bidWon">
					    Mes enchères remportées
					  </label>
				</div>
			</div>
			<div class="col">
				<div class="form-check ">
					  <input class="form-check-input" type="checkbox" value="" id="ventes">
					  <label class="form-check-label" for="ventes">
					    Ventes
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="sellInProgress" id="sellInProgress" disabled>
					  <label class="form-check-label" for="sellInProgress">
					    Mes ventes en cours
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="sellNotStarted" id="sellNotStarted" disabled>
					  <label class="form-check-label" for="sellNotStarted">
					    Ventes non débutées
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="" id="sellEnded" disabled>
					  <label class="form-check-label" for="sellEnded">
					    Ventes terminées
					  </label>
				</div>
			</div>
			<div class="col">
			<a href="#" class="btn btn-primary btn-lg " tabindex="-1" role="button" >Rechercher</a>
			</div>
			<div class="col">
			</div>
		</div>
		</form>
		<div class="row mt-5">
			<div class="card mb-3 single-enchere" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/auction.png" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'enchère a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Frédérick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3 single-enchere" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/auction.png" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'enchère a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Frédérick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3 single-enchere" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/auction.png" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'enchère a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Frédérick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3 single-enchere" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/auction.png" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'enchère a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Frédérick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3 single-enchere" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/auction.png" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Prix : 3 Euro <br/> Fin de l'enchère : 06/08/2021</p>
			        <p class="card-text"><small class="text-muted">Frédérick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3 single-enchere" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/auction.png" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'enchère a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Frédérick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</div>
	
</div>
<script>
$( "#ventes" ).on( "click", function() {
	 if($('#ventes').is(':checked')){
		 $("#sellInProgress").removeAttr('disabled');
		 $("#sellNotStarted").removeAttr('disabled');
		 $("#sellEnded").removeAttr('disabled');
	 } else {
		 $("#sellInProgress").attr('disabled','disabled');
		 $("#sellNotStarted").attr('disabled','disabled');
		 $("#sellEnded").attr('disabled','disabled');
		
	 }
	});
$( "#achat" ).on( "click", function() {
	 if($('#achat').is(':checked')){
		 $("#bidOpen").removeAttr('disabled');
		 $("#bidInProgress").removeAttr('disabled');
		 $("#bidWon").removeAttr('disabled');
	 } else {
		 $("#bidOpen").attr('disabled','disabled');
		 $("#bidInProgress").attr('disabled','disabled');
		 $("#bidWon").attr('disabled','disabled');
		
	 }
	});
	
</script>
</body>
</html>
