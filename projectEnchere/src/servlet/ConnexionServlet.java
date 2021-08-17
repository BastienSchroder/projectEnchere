package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.EnchereManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
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
		EnchereManager mgr = new EnchereManager();
		String identifiant = request.getParameter("identifiant").toString();
		String mdp = request.getParameter("mdp").toString();
		Utilisateur u1 = mgr.selectConnexion(identifiant, mdp);
		
		if (request.getParameter("seSouvenir") != null) {
			String seSouvenir = request.getParameter("seSouvenir");
			Cookie cookieIdentifiant = new Cookie("cookieIdentifiant", identifiant.trim());
			Cookie cookiePassword = new Cookie("cookiePassword", mdp.trim());
			Cookie cookieSeSouvenir = new Cookie("cookieSeSouvenir", seSouvenir.trim());
			cookieIdentifiant.setMaxAge(60 * 60 * 24 * 30);// 30 jours
			cookiePassword.setMaxAge(60 * 60 * 24 * 30);
			cookieSeSouvenir.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookieIdentifiant);
			response.addCookie(cookiePassword);
			response.addCookie(cookieSeSouvenir);
		}
		if(u1 != null) {
			session.setAttribute("noUtilisateur", u1.getNoUtilisateur());
			session.setMaxInactiveInterval(60*5);
			response.sendRedirect("accueil");
		}else {
			response.sendRedirect("connexion");
		}


			
		
	}

}
