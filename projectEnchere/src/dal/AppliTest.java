package dal;

import bo.Utilisateur;

public class AppliTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnchereDAO e = DAOFactory.getEnchereDAO();
		
		Utilisateur u1 = new Utilisateur("axel","axel","axel","axel","axel","axel","axel","axel","axel",5,true);
		try {
			e.insertUtilisateur(u1);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		
		
	}

}
