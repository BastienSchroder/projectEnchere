package bll;

import java.util.List;

import bo.ArticleVendu;
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
	
	public void deleteProfil(int noUtilisateur) {
		this.enchereDAO.deleteUtilisateur(noUtilisateur);
	}

	public List<ArticleVendu> selectArticles(){
		return this.enchereDAO.selectArticles();
	}
}
