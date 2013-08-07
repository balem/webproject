package py.edu.ucsa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.dao.DAOFactory;
import py.edu.ucsa.dto.UsuarioDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDTO user = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session == null){
			user = DAOFactory.getAutenticationDAO().autentiar(request.getParameter("user"), request.getParameter("password"));
			if(user != null){
				session = request.getSession(true);
				session.setMaxInactiveInterval(-1);
				session.setAttribute("usuario", user);
				request.getRequestDispatcher("menu.html").forward(request, response);
			}else{
				request.getRequestDispatcher("login.html").forward(request, response);
			}		
	
		}else{
			request.getRequestDispatcher("menu.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
