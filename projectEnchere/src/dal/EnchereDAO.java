package dal;

import java.util.List;

import bo.ArticleVendu;
import bo.Utilisateur;

public interface EnchereDAO {
	public void insertUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
	public Utilisateur selectConnexion(String identifiant, String mdp);
	public void deleteUtilisateur(int noUtilisateur);
	public List<ArticleVendu> selectArticles(); 
}
