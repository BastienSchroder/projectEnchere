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
import bo.Utilisateur;
import dal.EnchereDAO;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereManager mgr = new EnchereManager();
		HttpSession session = request.getSession();
		int noUtilisateur = -1;
		if(session.getAttribute("noUtilisateur") != null) {
			noUtilisateur = (int) session.getAttribute("noUtilisateur");
		}else {	
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
			if (rd!=null) {
				rd.forward(request, response);
			}	
		}
		Utilisateur u1 = mgr.selectUtilisateur(noUtilisateur);
		request.setAttribute("user1", u1);		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profil.jsp");
		if (rd!=null) {
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereManager mgr = new EnchereManager();
		
		int noUtilisateur = 1;
		
		
		
		Utilisateur u2 = new Utilisateur(
				noUtilisateur,
				request.getParameter("pseudo"),
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("email"),
				request.getParameter("tel"),
				request.getParameter("rue"),
				request.getParameter("cp"),
				request.getParameter("ville"),
				request.getParameter("mdp"),
				0,
				false
				);
		System.out.println(u2);
		mgr.updateUtilisateur(u2);
		
		doGet(request, response);
	}

}
