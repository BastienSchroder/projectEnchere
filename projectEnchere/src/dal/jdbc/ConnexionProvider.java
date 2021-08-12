package dal.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnexionProvider {
	private static DataSource datasource;
	/**
	 * Au chargement de la classe, la DataSource est recherch�e dans l'arbre JNDI
	 */
	static {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible de charger la ressource demand�e !");
		}
		
	}
	
	/**
	 * Cette m�thode retourne une connection op�rationnelle issue du pool de connexion
	 * vers la base de donn�es. 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//piocher une connexion dans le pool de connexions d�fini par le context.xml
		return datasource.getConnection();
	}
	
}
