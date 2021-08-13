package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//System.out.println(categ);
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
			System.out.println(request.getParameter("datestart")); 
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			 LocalDate datestart = LocalDate.parse(request.getParameter("datestart"), formatter);
			 System.out.println(datestart);
			 LocalDate dateend = LocalDate.parse(request.getParameter("dateend"), formatter);
			 System.out.println(dateend);
			/*Date dateend=null;
			try {
				dateend = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dateend"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(dateend);
			 SimpleDateFormat formater = null;
			 Date aujourdhui = new Date();
			 formater = new SimpleDateFormat("dd-MM-yyyy");
			    System.out.println(formater.format(dateend));
			 //Date test = formater.parse(dateend);
		 //LocalDate datestart = LocalDate.parse(request.getParameter("datestart"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// Date dateend = new SimpleDateFormat(request.getParameter("dateend")));
		 //System.out.println(request.getParameter("price"));
		
		 System.out.println(request.getParameter("article-name"));
		 System.out.println(request.getParameter("description"));
		 System.out.println(datestart);
		 System.out.println(dateend);
		 System.out.println(prixBase);
		 System.out.println(request.getParameter("price"));
		 System.out.println(formater);*/
		int prixBase = Integer.valueOf(request.getParameter("price"));
		int noCateg = Integer.valueOf(request.getParameter("selectCategorie"));
		ArticleVendu article = new ArticleVendu(
				request.getParameter("article-name"),
				request.getParameter("description"),
				datestart,
				dateend,
				prixBase,
				false,
				1,
				noCateg
					
		);
		//System.out.println(article);
		EnchereManager mgr = new EnchereManager();
		mgr.insertArticle(article);
		
		Retrait retrait = new Retrait(
				request.getParameter("rue"),
				request.getParameter("cp"),
				request.getParameter("ville")			
		);
		mgr.insertRetrait(retrait);
		RequestDispatcher rd = request.getRequestDispatcher("accueil");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

}
