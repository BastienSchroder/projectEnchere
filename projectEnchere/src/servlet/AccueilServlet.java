package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import bll.EnchereManager;
import bo.Categorie;
import bo.Enchere;
import bo.ArticleVendu;


/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EnchereManager mgr = new EnchereManager();
		ArrayList<Categorie> categ = mgr.selectCategorie();
		request.setAttribute("Categorie", categ);

		List<ArticleVendu> listeArticles = new ArrayList<>();
		List<ArticleVendu> listeArticlesFiltre = new ArrayList<>();
		listeArticles = mgr.selectArticles();

		List<ArticleVendu> attribut = (List<ArticleVendu>) request.getAttribute("listeArticleRechercher");
		if (attribut != null && !attribut.isEmpty()) {
			listeArticles = (List<ArticleVendu>) request.getAttribute("listeArticleRechercher");
		}else if(request.getAttribute("listeEnchereRemporte") != null) {
			listeArticles = (List<ArticleVendu>) request.getAttribute("listeEnchereRemporte");
		} else if (request.getAttribute("listeArticleRetourner") != null) {
			listeArticles = (List<ArticleVendu>) request.getAttribute("listeArticleRetourner");
		}

		//Mes encheres remportees
		if(request.getAttribute("listeEnchereRemporte") != null) {
			listeArticles = (List<ArticleVendu>) request.getAttribute("listeEnchereRemporte");
		}

		//Mes encheres en cours
		if(request.getAttribute("listeMesEncheresEnCours") != null) {
			listeArticles = (List<ArticleVendu>) request.getAttribute("listeMesEncheresEnCours");
		}
		
		//Encheres ouvertes
		if(request.getAttribute("filtreEncheresOuvertes") != null) {
			for(ArticleVendu article : listeArticles) {
				if(article.getDateFinEncheres().isAfter(LocalDate.now()) && article.getDateDebutEncheres().isBefore(LocalDate.now()) ) {
					listeArticlesFiltre.add(article);
				}
			}
			listeArticles = listeArticlesFiltre;
		}
		
		//Mes ventes en cours
		if(request.getAttribute("filtreMesVentesEnCours") != null) {
			for(ArticleVendu article : listeArticles) {
				if(article.getNoUtilisateur() == (int) session.getAttribute("noUtilisateur") && article.getDateFinEncheres().isAfter(LocalDate.now()) && article.getDateDebutEncheres().isBefore(LocalDate.now())) {
					listeArticlesFiltre.add(article);
				}
			}
			listeArticles = listeArticlesFiltre;
		}
		
		//Mes ventes terminées
		if(request.getAttribute("filtreMesVentesTerminees") != null) {
			for(ArticleVendu article : listeArticles) {
				if(article.getNoUtilisateur() == (int) session.getAttribute("noUtilisateur") && article.getDateFinEncheres().isBefore(LocalDate.now())){
					listeArticlesFiltre.add(article);
				}
			}
			listeArticles = listeArticlesFiltre;
		}
		
		//Mes ventes non débutées
		if(request.getAttribute("filtreMesVentesNonDebutees") != null) {
			for(ArticleVendu article : listeArticles) {
				if(article.getNoUtilisateur() == (int) session.getAttribute("noUtilisateur") && article.getDateDebutEncheres().isAfter(LocalDate.now())){
					listeArticlesFiltre.add(article);
				}
			}
			listeArticles = listeArticlesFiltre;
		}
		
		//Mes enchères en cours
		if(request.getAttribute("filtreMesEncheresEnCours") != null) {
			for(ArticleVendu article : listeArticles) {
				if(article.getDateFinEncheres().isAfter(LocalDate.now())){
					listeArticlesFiltre.add(article);
				}
			}
			listeArticles = listeArticlesFiltre;
		}
		
	
		
		request.setAttribute("listeArticles", listeArticles);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		if (rd!=null) {
			rd.forward(request, response);
		}	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<ArticleVendu> listeEnchere = null;
		EnchereManager mgr = new EnchereManager();
		String nomArticleRecherche = request.getParameter("nomArticleRechercher");
		int formSelect = -1;
		ArrayList<ArticleVendu> listeEnchereRemporte = null;
		if(request.getParameter("jokeConnecte") != null) {
			request.setAttribute("joke",request.getParameter("jokeConnecte"));
			request.setAttribute("answer",request.getParameter("answerConnecte") );
		}else {
			request.setAttribute("joke",request.getParameter("joke"));
			request.setAttribute("answer",request.getParameter("answer") );
		}

		if (nomArticleRecherche != null) {
			List<ArticleVendu> listeArticle = mgr.rechercheNomArticle(nomArticleRecherche);
			request.setAttribute("nomArticleRecherche", nomArticleRecherche);
			request.setAttribute("listeArticleRechercher", listeArticle);
		}
		if (request.getParameter("selectNumCat") != null) {
			formSelect = Integer.valueOf(request.getParameter("selectNumCat"));
			if(formSelect > 0) {
				List<ArticleVendu> listeArticleCat = (List<ArticleVendu>) mgr.selectArticleParNoCat(formSelect);
				request.setAttribute("listeArticleRetourner", listeArticleCat);
			}
		}
		
		if (session.getAttribute("noUtilisateur") != null) {
			int noUtilisateur = (int) session.getAttribute("noUtilisateur");
			String filtreEnchereRemporte = request.getParameter("filtreEnchereRemporte");
			String filtreEncheresOuvertes = request.getParameter("filtreEncheresOuvertes");
			String filtreMesVentesEnCours = request.getParameter("filtreMesVentesEnCours");
			String filtreMesVentesTerminees = request.getParameter("filtreMesVentesTerminees");
			String filtreMesVentesNonDebutees = request.getParameter("filtreMesVentesNonDebutees");
			String filtreMesEncheresEnCours = request.getParameter("filtreMesEncheresEnCours");
			request.setAttribute("filtreEncheresOuvertes", filtreEncheresOuvertes);
			request.setAttribute("filtreMesVentesEnCours", filtreMesVentesEnCours);
			request.setAttribute("filtreMesVentesTerminees", filtreMesVentesTerminees);
			request.setAttribute("filtreMesVentesNonDebutees", filtreMesVentesNonDebutees);
			if(filtreEnchereRemporte != null) {
				listeEnchereRemporte = mgr.selectEnchereRemporte(noUtilisateur);
				request.setAttribute("listeEnchereRemporte", listeEnchereRemporte);
			}
			
			if(filtreEnchereRemporte != null) {
				listeEnchere = mgr.selectEnchereRemporte(noUtilisateur);
				request.setAttribute("listeEnchereRemporte", listeEnchere);
			}
			
			if(filtreMesEncheresEnCours != null) {
				listeEnchere = mgr.selectEnchereEnCours(noUtilisateur);
				System.out.println(listeEnchere);
				request.setAttribute("listeMesEncheresEnCours", listeEnchere);
			}
			
		}
		
		
		doGet(request, response);
	}

}
