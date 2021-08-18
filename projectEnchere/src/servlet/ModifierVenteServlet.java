package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.EnchereManager;
import bo.ArticleVendu;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;

/**
 * Servlet implementation class ModifierVenteServlet
 */
@WebServlet("/modifier-vente")
public class ModifierVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EnchereManager mgr = new EnchereManager();
		int noArticle = Integer.valueOf(request.getParameter("noArticle"));
		Enchere enchere = mgr.selectDetailEnchere(noArticle);
		ArticleVendu article = mgr.selectArticleNo(noArticle);
		Categorie categorie = mgr.selectCategorieNo(article.getNoCategorie());
		ArrayList<Categorie> listeCategories = mgr.selectCategorie();
		Retrait retrait = mgr.selectRetraitNo(noArticle);
		HttpSession session = request.getSession();
		Utilisateur utilisateur = mgr.selectUtilisateur((int)session.getAttribute("noUtilisateur"));
		request.setAttribute("detailEnchere", enchere);
		request.setAttribute("article", article);
		request.setAttribute("categorie", categorie);
		request.setAttribute("listeCategories", listeCategories);
		request.setAttribute("retrait", retrait);
		request.setAttribute("utilisateur", utilisateur);

		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierVente.jsp");
		if (rd!=null) {
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EnchereManager mgr = new EnchereManager();
		int noCategorie = Integer.valueOf(request.getParameter("selectCategorie"));
		int noArticle= Integer.valueOf(request.getParameter("noArticle"));
		int miseAPrix = Integer.valueOf(request.getParameter("miseAPrix"));
		String date = request.getParameter("finEnchere");
	    LocalDate localDate = LocalDate.parse(date);
		Categorie nomCategorie = mgr.selectCategorieNo(noCategorie);
		
		if(request.getParameter("supprimer") != null) {
			mgr.deleteEnchere(noArticle);
			response.sendRedirect("accueil");
		}else {
		ArticleVendu article = new ArticleVendu(
				request.getParameter("nomArticle"),
				request.getParameter("description"),
				localDate,
				miseAPrix,
				nomCategorie.getNoCategorie(),
				noArticle
				);
		
		Retrait retrait = new Retrait( 
				noArticle,
				request.getParameter("retraitRue"),
				request.getParameter("codePostal"),
				request.getParameter("ville")
				);
		mgr.modifEnchere(article, retrait);
		response.sendRedirect("modifier-vente?noArticle="+noArticle);
		}
	}

}
