
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="bo.Categorie"%>
<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="bo.ArticleVendu" %>

<!DOCTYPE html>
<html>
<head>
<title>ENI-Enchère</title>
 <%@include file="require/head.jsp" %>
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body >

 <%@include file="require/header.jsp" %>
 <%ArrayList<Categorie> cl = (ArrayList<Categorie>)request.getAttribute("Categorie"); %>
<div class="row body">
	<h2 class="text-center list-title h1">Liste des enchères</h2>
	<div class=" row box-shadow margin-div">
	
		<div class="row">
			<h2>Filtres : </h2>
			<form class="d-flex col-6 col-sm-3 " action="<%= request.getContextPath()%>/accueil" method="POST">
				  <input type="hidden" name="joke" class="joke" >
				  <input type="hidden" name="answer" class="answer">
			      <input class="form-control me-2" type="text" placeholder="Mot clé" aria-label="Search" name="nomArticleRechercher">
			      <button id="btnBlague" class="btn btn-outline-success" type="submit">Rechercher</button>
			</form>
		</div>
		<br/>
		<form action="<%= request.getContextPath()%>/accueil" method="POST">
		
		<div class="row  mt-3">
			<div class="col-6 col-sm-1">
				<p>Catégorie </p>
			</div>
			<div class="col-6 col-sm-3">
				<select class="form-select" aria-label="Default select example" name="selectNumCat">
			  		<option selected value=0>-- Catégorie --</option>
			  		<%for (int i = 0; i < cl.size(); i++) {
			  		    Categorie categ = cl.get(i);
			  		  %><option value="<%= categ.getNoCategorie()%>"><%= categ.getLibelle()%></option><%
			  		}%> 
				</select>
			</div>

		</div>
		<div class="row">
			<div class="col">
					 <% if(session.getAttribute("noUtilisateur") != null) { %>

				<div class="form-check ">
					  <input class="form-check-input" type="checkbox" value="" id="achat">
					  <label class="form-check-label" for="achat">
					    Achats
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input name="filtreEncheresOuvertes" class="form-check-input" type="checkbox" value="bidOpen" id="bidOpen" disabled>
					  <label class="form-check-label" for="bidOpen" >
					    Enchères ouvertes
					  </label>
				</div>
				<div class="form-check margin-check">	  
					  <input name="filtreMesEncheresEnCours" class="form-check-input" type="checkbox" value="bidInProgress" id="bidInProgress" disabled>
					  <label class="form-check-label" for="bidInProgress">
					    Mes enchères en cours
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input name="filtreEnchereRemporte" class="form-check-input" type="checkbox" value="bidWon" id="bidWon" disabled>
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
					  <input name="filtreMesVentesEnCours"  class="form-check-input" type="checkbox" value="sellInProgress" id="sellInProgress" disabled>
					  <label class="form-check-label" for="sellInProgress">
					    Mes ventes en cours
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input name="filtreMesVentesNonDebutees"  class="form-check-input" type="checkbox" value="sellNotStarted" id="sellNotStarted" disabled>
					  <label class="form-check-label" for="sellNotStarted">
					    Ventes non débutées
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input name="filtreMesVentesTerminees"  class="form-check-input" type="checkbox" value="sellEnded" id="sellEnded" disabled>
					  <label class="form-check-label" for="sellEnded">
					    Ventes terminées
					  </label>
				</div>
				 <% } %>
			</div>
			<div class="col">
			<input id="btnBlagueConnecte" type="submit" class="btn btn-primary btn-lg " tabindex="-1" value="Rechercher" >
			</div>
			
		</div>
		 <input type="hidden" name="jokeConnecte" value="" class="joke">
		 <input type="hidden" name="answerConnecte" value="" class="answer">
		</form>
		
		<% if(session.getAttribute("noUtilisateur") != null) { %>
			<div class="row mt-5">
		<%
		List<ArticleVendu> listeArticles = (List<ArticleVendu>)request.getAttribute("listeArticles");		
		for(ArticleVendu article : listeArticles){
		%>
		<input type="hidden" name="dateFinEnchere" value="<%= article.getDateFinEncheres()%>">
		
            <div class="card mb-3 single-enchere" style="max-width: 540px;">
            <a id="divDetailVente" href="<%= request.getContextPath()%>/detail-vente?noArticle=<%= article.getNoArticle()%>">
              <div class="row no-gutters">
	                <div class="col-md-4">
	                  <img src="./vendor/img/auction.png" class="card-img" alt="...">
	                </div>
	                	<div class="col-md-8">
		                  <div class="card-body">
		                    <h5 class="card-title"><%= article.getNomArticle() %></h5>
		                    <p class="card-text">Prix : <%= article.getPrixInitiale()%></p>
		                    <p class="card-text">Fin de l'enchère : <%= article.getDateFinEncheres()%></p> 
		                    <p class="card-text"><small class="text-muted"><%= article.getPseudo()%></small></p>
		                  </div>
	              	  </div>
               </div>
            </a></div>
        
           	<%
			
			}
	%>
	</div>
			<% } else { %>
				<div class="row mt-5">
		<%
		List<ArticleVendu> listeArticles = (List<ArticleVendu>)request.getAttribute("listeArticles");		
		for(ArticleVendu article : listeArticles){
		%>
		<input type="hidden" name="dateFinEnchere" value="<%= article.getDateFinEncheres()%>">
		
            <div class="card mb-3 single-enchere" style="max-width: 540px;">
            
              <div class="row no-gutters">
	                <div class="col-md-4">
	                  <img src="./vendor/img/auction.png" class="card-img" alt="...">
	                </div>
	                	<div class="col-md-8">
		                  <div class="card-body">
		                    <h5 class="card-title"><%= article.getNomArticle() %></h5>
		                    <p class="card-text">Prix : <%= article.getPrixInitiale()%></p>
		                    <p class="card-text">Fin de l'ench�re : <%= article.getDateFinEncheres()%></p> 
		                    <p class="card-text"><small class="text-muted"><%= article.getPseudo()%></small></p>
		                  </div>
	              	  </div>
               </div>
            </div>
        
           	<%
			
			}
	%>
	</div>
			
			<% } %>
		
		
		
    </div>
    
<button id="pouf" class="pouf">Run Effect</button>
<button id="pif" class="pif">Run Effect</button>
<button id="paf" class="paf">Run Effect</button>
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


$( function() {
    $( "#pouf" ).on( "click", function() {
    	 $( ".testtt" ).toggle( "fade", 500 );
    });
    $( "#paf" ).on( "click", function() {
    	setInterval(function() {
    		 $( ".testtt" ).effect( "shake", 300 );
    	}, 70);
   	
   });
    
    $( "#pif" ).on( "click", function() {
    	$( ".testtt" ).toggle( "explode",2000 );
    	
   	
   });
} );

</script>
<script type="text/javascript" src="js/blagues.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
