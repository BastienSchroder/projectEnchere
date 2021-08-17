package servlet;

import java.io.IOException;

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
 * Servlet implementation class DetailVenteServlet
 */
@WebServlet("/detail-vente")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereManager mgr = new EnchereManager();
		int noArticle = Integer.valueOf(request.getParameter("noArticle"));
		Enchere enchere = mgr.selectDetailEnchere(noArticle);
		ArticleVendu article = mgr.selectArticleNo(noArticle);
		Categorie categorie = mgr.selectCategorieNo(article.getNoCategorie());
		Retrait retrait = mgr.selectRetraitNo(noArticle);
		HttpSession session = request.getSession();
		Utilisateur utilisateur = mgr.selectUtilisateur((int)session.getAttribute("noUtilisateur"));
		request.setAttribute("detailEnchere", enchere);
		request.setAttribute("article", article);
		request.setAttribute("categorie", categorie);
		request.setAttribute("retrait", retrait);
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/detailVente.jsp");

		if (rd!=null) {
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
