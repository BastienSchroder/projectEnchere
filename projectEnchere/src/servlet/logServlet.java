package servlet;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logServlet
 */
@WebServlet("/logservlet")
public class logServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileReader flux= null;
		 BufferedReader input= null;
		 //String textArea = new TextArea();
		 StringBuilder textArea = new StringBuilder();
		 String str;
		       try{ 
		           flux= new FileReader ("C:\\logs\\logging.log");
		  
		          input= new BufferedReader( flux);
		      
		         
		        while((str=input.readLine())!=null)
		        {
		        	 
		        	textArea.append(str); 
		        	textArea.append(System.getProperty("line.separator"));
		          }
		         }catch (IOException e)
		         {
		             System.out.println("Impossible d'ouvrir le fichier : " +e.toString()); 
		             }
		      finally{
		            try {
		                flux.close();
		            } catch (IOException ex) {
		               
		            }
		            System.out.println(textArea.toString());
		            request.setAttribute("textArea", textArea);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/log.jsp");
		if (rd != null) {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
