<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	<title>Page Inscription</title>
</head>
<body>
<h1 class="mb-5">ENI-ENCHERE - Page inscription </h1>
<h2 class="text-center mb-5">Création du profil</h2>
<form class="container row text-center">
	<div class="col">
		<div class="mb-3">
			<label for="pseudo">Pseudo : </label>
			<input type="text" name="pseudo" id="pseudo">
		</div>
		<div class="mb-3">
			<label for="prenom">Prenom : </label>
			<input type="text" name="prenom" id="prenom">
		</div>
		<div class="mb-3">
			<label>Téléphone : </label>
			<input type="telephone" name="telephone" id="telephone">
		</div>
		<div class="mb-3">
			<label for="cp">Code postale : </label>
			<input type="text" name="cp" id="cp" pattern="[0-9]" maxlength="5" placeholder="99999">
		</div>
		<div class="mb-3">
			<label for="mdp">Mot de passe : </label>
			<input type="password" name="mdp" id="mdp" placeholder="******">
		</div>
	</div>

	<div class="col">
	<div class="mb-3">
		<label for="nom">Nom : </label>
		<input type="nom" name="nom" id="nom">
	</div>
		<div class="mb-3">
			<label for="email">E-mail : </label>
			<input type="'email" name="email" id="email" placeholder="exemple@email.com">
		</div>
		<div class="mb-3">
			<label for="rue">Rue : </label>
			<input type="text" name="rue" id="rue">
		</div>
		<div class="mb-3">
			<label for="ville">Ville : </label>
			<input type="text" name="ville" id="ville">
		</div>
		<div class="mb-3">
			<label for="confirmation">Confirmation : </label>
			<input type="password" name="confirmation" id="confirmation" placeholder="******">
		</div>
	</div>

	<div class="row row-col-12 mt-5">
		<div class="col text-end">
			<button type="submit" class="btn btn-primary col-6">S'inscrire</button>
		</div>
		<div class="col text-start">
			<button type="" class="btn btn-warning col-6">Annuler</button>
		</div>
	</div>
	
	
	
</form>
</body>
</html>