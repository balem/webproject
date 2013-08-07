package py.edu.ucsa.dao;
import java.util.List;

import py.edu.ucsa.dto.AlumnoDTO;

public interface AlumnoDAO {
	
	List<AlumnoDTO> listar();
	
	public void insertar(AlumnoDTO a);
	public void actualizar(AlumnoDTO a);
	public void eliminar(int id);
	public AlumnoDTO obtenerAlumno(int id);
}
