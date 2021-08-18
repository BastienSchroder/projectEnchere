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
import bo.Utilisateur;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/admin")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereManager mgr = new EnchereManager();
		//int noUtilisateur = 1;
		
		ArrayList<Utilisateur> user = mgr.selectAllUtilisateur();
		request.setAttribute("Utilisateur", user);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/userList.jsp");
		if (rd!=null) {
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("usrToDel"));
		EnchereManager mgr = new EnchereManager();
		
		//mgr.deleteArticle(Integer.valueOf(request.getParameter("usrToDel")));
		mgr.deleteProfil(Integer.valueOf(request.getParameter("usrToDel")));
		doGet(request, response);
	}

}
