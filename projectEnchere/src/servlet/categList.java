package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereManager;
import bo.Categorie;

/**
 * Servlet implementation class categList
 */
@WebServlet("/categ")
public class categList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereManager mgr = new EnchereManager();
		//int noUtilisateur = 1;
		
		ArrayList<Categorie> categ = mgr.selectCategorie();
		request.setAttribute("Categorie", categ);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/categList.jsp");
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
		
		//mgr.deleteArticle(Integer.valueOf(request.getParameter("usrToDel")));
		mgr.deleteCategorie(Integer.valueOf(request.getParameter("categToDel")));
		doGet(request, response);
	}

}
