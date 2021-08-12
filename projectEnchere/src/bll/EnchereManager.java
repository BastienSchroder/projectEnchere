package bll;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public int insertUtilisateur(Utilisateur utilisateur) {
		return this.enchereDAO.insertUtilisateur(utilisateur);
	}
	
	public Utilisateur selectUtilisateur(int noUtilisateur) {
		return this.enchereDAO.selectUtilisateur(noUtilisateur);
	}
	
<<<<<<< Updated upstream
	public Utilisateur selectConnexion(String identifiant, String mdp) {
		return this.enchereDAO.selectConnexion(identifiant, mdp);
=======
	public void updateUtilisateur(Utilisateur utilisateur) {
		this.enchereDAO.updateUtilisateur(utilisateur);
>>>>>>> Stashed changes
	}

}
