package dal;

import bo.Utilisateur;

public interface EnchereDAO {
	public int insertUtilisateur(Utilisateur utilisateur);
	public Utilisateur selectUtilisateur(int noUtilisateur);
<<<<<<< Updated upstream
	public Utilisateur selectConnexion(String identifiant, String mdp);
=======
	public void updateUtilisateur(Utilisateur utilisateur);
>>>>>>> Stashed changes
}
