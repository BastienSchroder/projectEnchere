package dal;

import java.util.ArrayList;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Retrait;
import bo.Utilisateur;

public interface EnchereDAO {
	public void insertUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
	public ArrayList<Categorie> selectCategorie();
	public void insertArticle(ArticleVendu article);
	public void insertRetrait(Retrait retrait);
	
}
