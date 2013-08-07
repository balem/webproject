package py.edu.ucsa.dao;

import py.edu.ucsa.dao.impl.hibernate.AlumnoDAOHibernetImpl;
import py.edu.ucsa.dao.impl.hibernate.AutenticationDAOHibernateImpl;
import py.edu.ucsa.dao.impl.hibernate.ProyectoDAO;
import py.edu.ucsa.dao.impl.hibernate.ProyectoDAOHibernateImpl;

public class DAOFactory {
	
	public static ProyectoDAO getProyectoDAO() {
		return new ProyectoDAOHibernateImpl();
	}
	
	public static AutenticationDAO getAutenticationDAO() {
		return new AutenticationDAOHibernateImpl();
	}
	
	public static AlumnoDAO getAlumnoDAO() {
		return new AlumnoDAOHibernetImpl();
	}

}
