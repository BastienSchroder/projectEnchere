package dal;

import dal.jdbc.EnchereDAOJdbcImpl;

public class DAOFactory {
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
}
