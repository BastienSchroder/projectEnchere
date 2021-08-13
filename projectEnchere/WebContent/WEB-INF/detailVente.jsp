<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail vente</title>
<%@include file="require/head.jsp" %>

</head>
<body>
<%@include file="require/header.jsp" %>

<div class="row body">
	<h2 class="text-center mb-5 list-title h1">Détail vente</h2>
	<div class="container">
		<div class=" row box-shadow margin-div">
			
				<div class="col-4">
					<img src="..." srcset="https://images.unsplash.com/photo-1503602642458-232111445657?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1834&q=80" class="img-fluid" alt="...">
				</div>
				<div class="col-6">
					<h3 class="mb-3">Tabouret en bois</h3>
					<p><b>Description du produit : </b></p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec turpis in arcu dictum varius. Sed commodo lobortis lectus, vitae.
					</p class="mb-3"><b>Catégorie : </b>
					<p>MOBILIER</p>
					</p class="mb-3"><b>Meilleure offre : </b>
					<p>210 points par Bob</p>
					</p class="mb-3"><b>Mise à prix : </b>
					<p>185 points</p>
					</p class="mb-3"><b>Fin de l'enchère : </b>
					<p>09/10/2021</p>
					</p class="mb-3"><b>Retrait : </b>
					<p>10 allée des Alouettes <br>44 800 Saint-Herblain</p>
					<p class="mb-3"><b>Vendeur : </b></p>
					<p>Jojo 44</p>
					<p class="mb-3"><b>Ma proposition : </b></p>
					<p>09/10/2021</p>
		
					<form>
						<label for="encherir" class="m"><b>Ma proposition : </b></label>
						<div class="input-group mb-3">
		  					<input type="number" class="form-control" placeholder="220" aria-label="Recipient's username" aria-describedby="button-addon2">
		  					<button class="btn btn-outline-success" type="button" id="button-addon2">Enchérir</button>
						</div>
					</form>
			
		</div>
	</div>
</div>	

</body>
</html>