package py.edu.ucsa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.edu.ucsa.connections.ManejadorBD;
import py.edu.ucsa.dao.DAOFactory;
import py.edu.ucsa.dto.AlumnoDTO;

/**
 * Servlet implementation class ListarServlet
 */
@WebServlet("/ListarServlet")
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AlumnoDTO> lista = DAOFactory.getAlumnoDAO().listar();
		if(lista != null){
			HttpSession session = request.getSession(false);
			if(session != null){
				session.setAttribute("alumnos", lista);
			}
		}
		request.getRequestDispatcher("grilla.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
