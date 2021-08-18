package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereManager;
import bo.Categorie;
import bo.Retrait;

/**
 * Servlet implementation class addCateg
 */
@WebServlet("/addcateg")
public class addCateg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCateg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/addCateg.jsp");
		if (rd!=null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getParameter("categToDel")
		EnchereManager mgr = new EnchereManager();
		Categorie categ = new Categorie(
				request.getParameter("libelle")
							
		);
		System.out.println("dfgsdfgsdfgsdfg"+request.getParameter("libelle"));
		mgr.insertCategorie(categ);
		doGet(request, response);
	}

}
