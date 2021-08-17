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
		// TODO Auto-generated method stub

		EnchereManager mgr = new EnchereManager();
		//int noUtilisateur = 1;
		
		ArrayList<Categorie> categ = mgr.selectCategorie();
		request.setAttribute("Categorie", categ);

		List<ArticleVendu> listeArticles = new ArrayList<>();
		listeArticles = mgr.selectArticles();
		if(request.getAttribute("listeEnchereRemporte") != null) {
			listeArticles = (List<ArticleVendu>) request.getAttribute("listeEnchereRemporte");
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String filtreEnchereRemporte = request.getParameter("filtreEnchereRemporte");
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		ArrayList<ArticleVendu> listeEnchereRemporte = null;
		EnchereManager mgr = new EnchereManager();
		if(filtreEnchereRemporte != null) {
			listeEnchereRemporte = mgr.selectEnchereRemporte(noUtilisateur);
			request.setAttribute("listeEnchereRemporte", listeEnchereRemporte);
		}
		doGet(request, response);
	}

}
