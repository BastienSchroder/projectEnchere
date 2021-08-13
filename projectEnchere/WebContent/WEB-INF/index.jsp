<%@ page import="java.util.List" %>
<%@ page import="bo.ArticleVendu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-Enchère</title>
 <%@include file="require/head.jsp" %>
</head>
<body>

 <%@include file="require/header.jsp" %>
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
			  		<option value="0">Culotte</option>
			  		<option value="1">String</option>
			  		<option value="2">Chausette</option>
			  		<option value="3">Tanga</option>
			  		<option value="4">Babouche</option>
				</select>
			</div>
			<%
			List<ArticleVendu> listeArticles = (List<ArticleVendu>)request.getAttribute("listeArticles");
			
			%>
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
