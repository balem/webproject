package py.edu.ucsa.dao;

import py.edu.ucsa.dto.UsuarioDTO;

public interface AutenticationDAO {
	UsuarioDTO autentiar(String user, String password);
}
