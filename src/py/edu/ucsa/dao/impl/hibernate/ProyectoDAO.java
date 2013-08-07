package py.edu.ucsa.dao.impl.hibernate;

import java.util.List;
import py.edu.ucsa.dto.ProyectoDTO;

public interface ProyectoDAO {
	void insert (ProyectoDAO p);
	void update (ProyectoDAO p);
	void delete (long id);
	
	List<ProyectoDTO> getproyectos();
	ProyectoDTO getProyectoByID(long id);
}
