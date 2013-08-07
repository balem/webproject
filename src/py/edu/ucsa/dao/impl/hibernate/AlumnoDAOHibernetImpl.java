package py.edu.ucsa.dao.impl.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import py.edu.ucsa.connections.ManejadorBD;
import py.edu.ucsa.dao.AlumnoDAO;
import py.edu.ucsa.dto.AlumnoDTO;

public class AlumnoDAOHibernetImpl implements AlumnoDAO {

	@Override
	public List<AlumnoDTO> listar() {
		String query ="select * from alumno";
		Statement stm;
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();
		ResultSet rs = null;
		ManejadorBD manDb = new  ManejadorBD();
		AlumnoDTO alumno = null;
		try {
			stm = manDb.getCon().createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				alumno = new AlumnoDTO();
				alumno.setId(Integer.parseInt(rs.getString("id")));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("apellido"));
				listaAlumnos.add(alumno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAlumnos;
	}

	@Override
	public void insertar(AlumnoDTO a) {
		String query = "INSERT INTO alumno( nombre, apellido) VALUES (?, ?)";
		PreparedStatement stm;
		ManejadorBD manDBd = new ManejadorBD();
		try {
			stm = manDBd.getCon().prepareStatement(query);
			stm.setString(1, a.getNombre());
			stm.setString(2, a.getApellido());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizar(AlumnoDTO a) {
		String query = "UPDATE alumno SET nombre=?, apellido=? WHERE id="+a.getId();
		PreparedStatement stm;
		ManejadorBD manDb = new ManejadorBD();
		try {
			stm = manDb.getCon().prepareStatement(query);
			stm.setString(1, a.getNombre());
			stm.setString(2, a.getApellido());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(int id) {
		String query ="delete from alumno where id = "+id;
		Statement stm;
		ManejadorBD manDb = new ManejadorBD();
		try {
			stm = manDb.getCon().createStatement();
			stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public AlumnoDTO obtenerAlumno(int id) {
		String query ="select * from alumno where id = "+id;
		Statement stm;
		ResultSet rs = null;
		ManejadorBD manDb = new  ManejadorBD();
		AlumnoDTO alumno = null;
		try {
			stm = manDb.getCon().createStatement();
			rs = stm.executeQuery(query);
			while(rs.next()){
				alumno = new AlumnoDTO();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("Apellido"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		
		return alumno;
		
	}
	

}
