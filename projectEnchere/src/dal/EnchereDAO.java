package dal;
import java.time.LocalDate;
import java.util.ArrayList;
import bo.ArticleVendu;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import java.util.List;
import bo.Utilisateur;

public interface EnchereDAO {
	public int insertUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
	public ArrayList<Categorie> selectCategorie();
	public void insertArticle(ArticleVendu article);
	public void insertRetrait(Retrait retrait);
	public void insertEnchere(Enchere enchere);
	public Utilisateur selectConnexion(String identifiant, String mdp);
	public void deleteUtilisateur(int noUtilisateur);
	public List<ArticleVendu> selectArticles(); 
	public void updateUtilisateur(Utilisateur utilisateur);
	public Enchere selectDetailEnchere(int noArticle);
	public ArticleVendu selectArticleNo(int noArticle);
	public Categorie selectCategorieNo(int noCategorie);
	public Retrait selectRetraitNo(int noArticle);
	public int updateEnchere(int noArticle,int noUtilisateur, int montantEnchere);
	public void updateUtilisateurCredit(int noUtilisateur,int montant);
	public ArrayList<ArticleVendu> selectEnchereRemporte(int noUtilisateur);
	public void modifEnchereArticle(ArticleVendu article);
	public void modifEnchereRetrait(Retrait retrait);
	public void deleteEnchere(int noArticle);
	public void updateEtatVente(int noArticle);
	ArrayList<ArticleVendu> selectEnchereUtilisateur(int noUtilisateur);
	public List<ArticleVendu> rechercheNomArticle(String nomArticle);
	public List<ArticleVendu> selectArticleParNoCat (int noCat);
}
