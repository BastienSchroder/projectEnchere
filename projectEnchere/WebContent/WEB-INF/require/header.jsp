<nav class="navbar navbar-light bg-light header">
  <div class="container-fluid">
    <div class="col-3"><a href="<%= request.getContextPath()%>/accueil"><img class="logo-page"
     src="./vendor/img/logo.png"
     alt="Le logo de la hess" ></a>
	</div>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Navigation ENI-Enchère</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
		  	<a class="nav-link active" aria-current="page" href="/projectEnchere/accueil">Enchères</a>
          </li>
          
          <% if(session.getAttribute("noUtilisateur") == null) { %>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/projectEnchere/connexion">Connexion</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/projectEnchere/inscription">Inscription</a>
          </li>
          <% } %>
          <% if(session.getAttribute("noUtilisateur") != null) { %>
          <li class="nav-item">
            <a class="nav-link active" href="/projectEnchere/new-vente">Vendre un article</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/projectEnchere/profil">Mon profil</a>
          </li>
        	  <li class="nav-item">
            <a class="nav-link active" tabindex="-1" href="<%= request.getContextPath()%>/deconnexion">Déconnexion</a>
          </li>     	  
          <% } %>
          
        </ul>
      </div>
    </div>
  </div>
</nav>






