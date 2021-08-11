<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	  <!-- Custom styles for this template -->
	  
    <link href="./vendor/css/styles.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="row header">
	<div class="col-3"><img class="logo"
     src="./vendor/img/logo.png"
     alt="Le logo de la hess">
	</div>
	<div class="col align-items-right">
		<ul class="nav justify-content-end align-middle">
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="#">Ench�res</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="/projectEnchere/connexion">Connexion</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="/projectEnchere/inscription">Inscription</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Vendre un article</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Mon profil</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">D�connexion</a>
			  </li>
		</ul>
	</div>	
</div>
<div class="row body">
	<h2 class="text-center list-title h1">Liste des ench�res</h2>
	<div class=" row box-shadow margin-div">
	
		<div class="row">
			<h2>Filtres : </h2>
			<form class="d-flex col-6 col-sm-3 ">
			      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
		<br/>
		<div class="row  mt-3">
			<div class="col-6 col-sm-1">
				<p>Cat�gorie </p>
			</div>
			<div class="col-6 col-sm-3">
				<select class="form-select" aria-label="Default select example">
			  		<option selected>-- Cat�gorie --</option>
			  		<option value="0">Culotte</option>
			  		<option value="1">String</option>
			  		<option value="2">Chausette</option>
			  		<option value="3">Tanga</option>
			  		<option value="4">Babouche</option>
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
					    Ench�res ouvertes
					  </label>
				</div>
				<div class="form-check margin-check">	  
					  <input class="form-check-input" type="checkbox" value="bidInProgress" id="bidInProgress" disabled>
					  <label class="form-check-label" for="bidInProgress">
					    Mes ench�res en cours
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="bidWon" id="bidWon" disabled>
					  <label class="form-check-label" for="bidWon">
					    Mes ench�res remport�es
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
					    Ventes non d�but�es
					  </label>
				</div>
				<div class="form-check margin-check">
					  <input class="form-check-input" type="checkbox" value="" id="sellEnded" disabled>
					  <label class="form-check-label" for="sellEnded">
					    Ventes termin�es
					  </label>
				</div>
			</div>
			<div class="col">
			<a href="#" class="btn btn-primary btn-lg " tabindex="-1" role="button" >Rechercher</a>
			</div>
			<div class="col">
			</div>
		</div>
		<div class="row mt-5">
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/enchere.jpg" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'ench�re a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Fr�d�rick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/enchere.jpg" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'ench�re a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Fr�d�rick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/enchere.jpg" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'ench�re a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Fr�d�rick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/enchere.jpg" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'ench�re a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Fr�d�rick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/enchere.jpg" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Prix : 3 Euro <br/> Fin de l'ench�re : 06/08/2021</p>
			        <p class="card-text"><small class="text-muted">Fr�d�rick la terreur</small></p>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row no-gutters">
			    <div class="col-md-4">
			      <img src="./vendor/img/enchere.jpg" class="card-img" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Exemple enchere</h5>
			        <p class="card-text">Teste pour l'ench�re a remplacer plus tard</p>
			        <p class="card-text"><small class="text-muted">Fr�d�rick la terreur</small></p>
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
