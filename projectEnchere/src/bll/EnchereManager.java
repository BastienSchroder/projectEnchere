package bll;

import java.util.ArrayList;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Retrait;
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
	public void insertArticle(ArticleVendu article) {
		this.enchereDAO.insertArticle(article);
	}
	public void insertRetrait(Retrait retrait) {
		this.enchereDAO.insertRetrait(retrait);
	}
	public Utilisateur selectUtilisateur(int noUtilisateur) {
		return this.enchereDAO.selectUtilisateur(noUtilisateur);
	}
	public ArrayList<Categorie> selectCategorie(){
		return this.enchereDAO.selectCategorie();
		
	}

}
