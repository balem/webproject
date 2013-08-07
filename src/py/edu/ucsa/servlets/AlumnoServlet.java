package py.edu.ucsa.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import py.edu.ucsa.dao.DAOFactory;
import py.edu.ucsa.dto.AlumnoDTO;

/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet("/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		 
		if(session != null){
			if(request.getParameter("accion").equals("eliminar")){
				DAOFactory.getAlumnoDAO().eliminar(Integer.parseInt(request.getParameter("id")));
				List<AlumnoDTO> lista = DAOFactory.getAlumnoDAO().listar();
			 	session.setAttribute("alumnos", lista);
			 	request.getRequestDispatcher("grilla.jsp").forward(request, response);
			}else if(request.getParameter("accion").equals("agregar")){
			 	AlumnoDTO alumno = new AlumnoDTO();
			 	alumno.setNombre(request.getParameter("nombre"));
			 	alumno.setApellido(request.getParameter("apellido"));
			 	DAOFactory.getAlumnoDAO().insertar(alumno);
			 	List<AlumnoDTO> lista = DAOFactory.getAlumnoDAO().listar();
			 	request.setAttribute("alumnos", lista);	
				request.getRequestDispatcher("grilla.jsp").forward(request, response);
			}else if(request.getParameter("accion").equals("actualizar")){
				AlumnoDTO alumno = DAOFactory.getAlumnoDAO().obtenerAlumno(Integer.parseInt(request.getParameter("id")));
				alumno.setApellido(request.getParameter("apellido"));
				alumno.setNombre(request.getParameter("nombre"));
				DAOFactory.getAlumnoDAO().actualizar(alumno);
				List<AlumnoDTO> lista = DAOFactory.getAlumnoDAO().listar();
			 	session.setAttribute("alumnos", lista);
			 	request.getRequestDispatcher("grilla.jsp").forward(request, response);
			}else if(request.getParameter("accion").equals("modificar")){
				AlumnoDTO alumno = DAOFactory.getAlumnoDAO().obtenerAlumno(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("alumno", alumno);
				request.getRequestDispatcher("addalumno.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
