package bll;


import java.util.ArrayList;
import bo.ArticleVendu;
import bo.Categorie;
import bo.Enchere;
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
	
	public Enchere selectDetailEnchere(int noArticle) {
		return this.enchereDAO.selectDetailEnchere(noArticle);
	}
	
	public ArticleVendu selectArticleNo(int noArticle) {
		return this.enchereDAO.selectArticleNo(noArticle);
	}
	
	public Categorie selectCategorieNo(int noCategorie) {
		return this.enchereDAO.selectCategorieNo(noCategorie);
	}
	
	public Retrait selectRetraitNo(int noArticle) {
		return this.enchereDAO.selectRetraitNo(noArticle);
	}
	
	public void insertEnchere(Enchere enchere) {
		this.enchereDAO.insertEnchere(enchere);
	}
	
	public void encherir(int noArticle, int noUtilisateur,int montantEnchere) {
		if(this.enchereDAO.updateEnchere(noArticle,noUtilisateur,montantEnchere) > 0) {
			this.enchereDAO.updateUtilisateurCredit(noUtilisateur, montantEnchere);
		}		
	}
}
