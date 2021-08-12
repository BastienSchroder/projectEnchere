package dal;

import bo.Utilisateur;

public interface EnchereDAO {
	public void insertUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
	public Utilisateur selectConnexion(String identifiant, String mdp);
}
