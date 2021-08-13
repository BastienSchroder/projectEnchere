package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereManager;
import bo.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u1 = new Utilisateur(
				request.getParameter("pseudo"),
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("email"),
				request.getParameter("telephone"),
				request.getParameter("rue"),
				request.getParameter("cp"),
				request.getParameter("ville"),
				request.getParameter("mdp"),0,false
				);
		EnchereManager mgr = new EnchereManager();
		
		if (!request.getParameter("mdp").equals(request.getParameter("confirmation"))) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			if (rd != null) {
				rd.forward(request, response);
			}
		} else {
			if (mgr.insertUtilisateur(u1) != -1) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			}
		}
		
	}

}

