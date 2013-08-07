package py.edu.ucsa.dao.impl.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.ucsa.connections.ManejadorBD;
import py.edu.ucsa.dao.AutenticationDAO;
import py.edu.ucsa.dto.UsuarioDTO;

public class AutenticationDAOHibernateImpl implements AutenticationDAO {
	private UsuarioDTO usr = null;
	@Override
	public UsuarioDTO autentiar(String user, String password) {
		String query ="SELECT count(*) from usuarios where username like ? and pass like ?";
		PreparedStatement stm;
		ResultSet rs = null;
		
		ManejadorBD mdb = new ManejadorBD();
		try {
			stm = mdb.getCon().prepareStatement(query);
			stm.setString(1, user);
			stm.setString(2, password);
			rs = stm.executeQuery();
			if(rs.next()){
				usr = new UsuarioDTO();
				usr.setUsuario(user);
				usr.setPassword(password);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return usr;
	}
	

}
