<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@page import="bo.Categorie"%>
    <%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle vente</title>
<%@include file="require/head.jsp" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">

</head>
<body>
<%@include file="require/header.jsp" %>
<%ArrayList<Categorie> cl = (ArrayList<Categorie>)request.getAttribute("Categorie"); %>
<div class="row body">
	<h2 class="text-center list-title h1">Nouvelle ventes</h2>
	<div class=" row box-shadow margin-div">
	<div  class=" padding-new-vente col-sm-12 col-md-12 col-lg-7">
		<form action="<%= request.getContextPath()%>/new-vente" method="POST">
			  <div class="mb-3 col-sm-12 col-md-12 col-lg-3">
			    <label for="article-name" class="form-label">Nom de l'article</label>
			    <input type="text" name="article-name" class="form-control" id="article-name" >
			  </div>
			  <div class="col-sm-12 col-md-12 col-lg-5 mb-3">
			    <label for="description" class="form-label">Description</label>
			    <textarea class="form-control" name="description" id="description" rows="3"></textarea>
			  </div>
			  <div class="mb-3 col-sm-12 col-md-12 col-lg-3">
			  <label  class="form-label">Catégorie</label>
				<select id="selectCategorie" name="selectCategorie" class="form-select" >
			  		<option selected>-- Catégorie --</option>
			  		<%for (int i = 0; i < cl.size(); i++) {
			  		    Categorie categ = cl.get(i);
			  		  %><option value="<%= categ.getNoCategorie()%>"><%= categ.getLibelle()%></option><%
			  		    
			  		}%> 		
				</select>
			</div>
			
			 <div class=" col-sm-12 col-md-12 col-lg-2 mb-3">
			    <label for="price" class="form-label">Mise à prix</label>
			    <input type="number" name="price" class="form-control" id="price" >
			  </div>
			  <div class="  col-sm-12 col-md-12 col-lg-3 mb-3">
			    <label for="datestart" class="form-label">Date de début de l'enchère</label>
			    <input class="datepicker" name="datestart" type="text" id="datestart">
			  </div>
			  <div class=" col-sm-12 col-md-12 col-lg-3 mb-3">
			    <label for="dateend" class="form-label">Date de fin de l'enchère</label>
			    <input class="datepicker" name="dateend" type="text" id="dateend">
			  </div>
			  <div class="col-sm-12 col-md-6 mb-3 retrait">
			  <h4>Adresse de retrait :</h4>
			  <div class=" col-sm-12 col-md-12 col-lg-4 mb-3">
				    <label for="rue" class="form-label">Rue : </label>
				    <input type="text" name="rue" class="form-control" id="rue" >
			    </div>
			    <div class=" col-sm-12 col-md-12 col-lg-4 mb-3">
				    <label for="cp" class="form-label">Code postal : </label>
				   <input type="number" name="cp" id="cp" pattern="[0-9]" maxlength="5" placeholder="99999">
			   </div>
			   <div class=" col-sm-12 col-md-12 col-lg-4 mb-3">
				    <label for="ville" class="form-label">Ville : </label>
				    <input type="text" class="form-control" name="ville" id="ville" >
			    </div>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Enregistrer</button>
			  <a href="accueil" class="btn btn-primary">Annuler</a>
			  
		</form>
	</div>
	<div  class=" tip-box col-5">
	<h2><strong>Information pour cr&eacute;er une nouvelle Ench&egrave;re :</strong></h2>
<p><strong></strong></p>
<p><strong>- Le nom de l'article sera celui affich&eacute; aux utilisateur, privil&eacute;giez des mots cl&eacute;s.</strong></p>
<p></p>
<p><strong>- La description est faite pour donner plus de d&eacute;tail sur l'article,</strong></p>
<p><strong>faites un minimum d'effort sur celle-ci pour donner envie aux futurs acqu&eacute;reur !</strong></p>
<p></p>
<p><strong>- La cat&eacute;gorie facilite la recherche des acqu&eacute;reur, v&eacute;rifier que votre vente est bien dans la bonne cat&eacute;gorie.</strong></p>
<p></p>
<p><strong>- La mise &agrave; prix correspond &agrave; la somme minimale que vous souhaitez percevoir,</strong></p>
<p><strong>cependant ce n'est certainement pas la maximal que vous percevrez !</strong></p>
<p></p>
<p><strong>- Pour ce qui est des dates, elles correspondent &agrave; la p&eacute;riode sur laquelle il est possible d'ench&eacute;rir.</strong></p>
<p></p>
<p><strong>- Le point de retrait est important car c'est l'endroit ou le gagnant devra venir chercher son bien.</strong></p>
	</div>
	
</div>
</div>
<script>
$(function() {
    $( ".datepicker" ).datepicker(
            {
                 
                dateFormat: 'dd/mm/yy',
                monthNames: ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Âout", "Septembre", "Octobre", "Novembre", "Décembre"],
                monthNamesShort: [ "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Âout", "Septembre", "Octobre", "Novembre", "Décembre" ],
                dayNames: [ "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi" ],
                dayNamesMin: [ "Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa" ],
                changeMonth: true,
                changeYear: true,
                yearRange: '1950:2022'
                 
            });
     
 
     
  });
</script>
</body>
</html>
