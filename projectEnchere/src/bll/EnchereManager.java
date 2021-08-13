package bll;


import java.util.ArrayList;
import bo.ArticleVendu;
import bo.Categorie;
import bo.Retrait;
import java.util.List;
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


	public Utilisateur selectConnexion(String identifiant, String mdp) {
		return this.enchereDAO.selectConnexion(identifiant, mdp);
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) {
		this.enchereDAO.updateUtilisateur(utilisateur);
	}
	
	public void deleteProfil(int noUtilisateur) {
		this.enchereDAO.deleteUtilisateur(noUtilisateur);
	}

	public List<ArticleVendu> selectArticles(){
		return this.enchereDAO.selectArticles();
	}
}
