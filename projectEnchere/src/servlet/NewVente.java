package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;  
import bll.EnchereManager;
import bo.ArticleVendu;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;

/**
 * Servlet implementation class NewVente
 */
@WebServlet("/new-vente")
public class NewVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EnchereManager mgr = new EnchereManager();
		//int noUtilisateur = 1;
		
		ArrayList<Categorie> categ = mgr.selectCategorie();
		request.setAttribute("Categorie", categ);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/newVente.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate datestart = LocalDate.parse(request.getParameter("datestart"), formatter);
		 LocalDate dateend = LocalDate.parse(request.getParameter("dateend"), formatter);
		int prixBase = Integer.valueOf(request.getParameter("price"));
		int noCateg = Integer.valueOf(request.getParameter("selectCategorie"));
		HttpSession session = request.getSession();
		EnchereManager mgr = new EnchereManager();

		ArticleVendu article = new ArticleVendu(
				request.getParameter("article-name"),
				request.getParameter("description"),
				datestart,
				dateend,
				prixBase,
				false,
				(int) session.getAttribute("noUtilisateur"),
				noCateg
					
		);
		mgr.insertArticle(article);
		
		Retrait retrait = new Retrait(
				request.getParameter("rue"),
				request.getParameter("cp"),
				request.getParameter("ville")			
		);
		mgr.insertRetrait(retrait);
		
		Enchere enchere = new Enchere(
				datestart,
				prixBase
				);
		mgr.insertEnchere(enchere);
		
		RequestDispatcher rd = request.getRequestDispatcher("accueil");
		if (rd != null) {
			rd.forward(request, response);
		}
		
	}

}
