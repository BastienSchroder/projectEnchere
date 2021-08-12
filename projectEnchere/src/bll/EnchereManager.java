package bll;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public void insertUtilisateur(Utilisateur utilisateur) {
		this.enchereDAO.insertUtilisateur(utilisateur);
	}
	
	public Utilisateur selectUtilisateur(int noUtilisateur) {
		return this.enchereDAO.selectUtilisateur(noUtilisateur);
	}
	
	public Utilisateur selectConnexion(String identifiant, String mdp) {
		return this.enchereDAO.selectConnexion(identifiant, mdp);
	}

}
