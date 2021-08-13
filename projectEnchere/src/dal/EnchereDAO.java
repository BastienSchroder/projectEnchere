package dal;
import java.util.ArrayList;
import bo.ArticleVendu;
import bo.Categorie;
import bo.Retrait;
import java.util.List;
import bo.Utilisateur;

public interface EnchereDAO {
	public int insertUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
	public ArrayList<Categorie> selectCategorie();
	public void insertArticle(ArticleVendu article);
	public void insertRetrait(Retrait retrait);
	public Utilisateur selectConnexion(String identifiant, String mdp);
	public void deleteUtilisateur(int noUtilisateur);
	public List<ArticleVendu> selectArticles(); 
	public void updateUtilisateur(Utilisateur utilisateur);
}
