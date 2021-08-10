<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

	<div class="d-flex justify-content-center align-items-center container h-100 ">
	<form action="" method="POST" id="form">
	<div class="row">
		<div class="mb-3">
		    <label for="inputIdentifiant" class="form-label">Identifiant :</label>
		    <input type="text" id="inputIdentifiant" class="form-control">
		</div>

		<div class="mb-3">
			    <label for="inputMotDePasse" class="form-label">Mot de passe :</label>
			    <input type="password" id="inputMotDePasse" class="form-control">
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
</body>
</html>