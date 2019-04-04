package Zafar;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validacion
 */
@WebServlet("/validacion")
public class validacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String nik = request.getParameter("nombre");
		
		String pass = request.getParameter("contra");
		Pattern pat1 = Pattern.compile("^[a-zA-Z0-9]{1,9}$");
		Matcher mat1 = pat1.matcher(nik);
		
		Pattern pat = Pattern.compile("^[A-Za-z0-9]+([.|-][A-za-z0-9]+)*@[A-Za-z0-9]+([.|-][A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(email);
		
		Pattern pat2 = Pattern.compile("^[a-zA-Z0-9]{8,}$");
		Matcher mat2 = pat2.matcher(pass);
	
		if (mat.find()|| mat1.find()||mat2.find()) {
			
			getServletContext().getRequestDispatcher("/html/ok.html").forward(request, response);
				
		}else {
			getServletContext().getRequestDispatcher("/html/error.html").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
