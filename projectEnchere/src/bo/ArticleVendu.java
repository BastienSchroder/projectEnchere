package bo;

import java.time.LocalDate;
import java.util.Date;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitiale;
	private int prixVente;
	private boolean etatVente;
	private int noUtilisateur;
	private int noCategorie;
	private String pseudo;
	
	


	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitiale, int prixVente, boolean etatVente, int noUtilisateur,
			int noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitiale = prixInitiale;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}

	
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitiale, int prixVente, boolean etatVente, String pseudo ) {

		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitiale = prixInitiale;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.pseudo = pseudo;

	}


	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int prixInitiale, boolean etatVente, int noUtilisateur, int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitiale = prixInitiale;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}







	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitiale, int prixVente, boolean etatVente, int noUtilisateur,
			int noCategorie, String pseudo) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitiale = prixInitiale;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.pseudo = pseudo;
	}
	
	



	public ArticleVendu(String nomArticle, String description, LocalDate dateFinEncheres, int prixInitiale,
			int noCategorie,int noArticle) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitiale = prixInitiale;
		this.noCategorie = noCategorie;
		this.noArticle = noArticle;
	}



	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getPrixInitiale() {
		return prixInitiale;
	}
	public void setPrixInitiale(int prixInitiale) {
		this.prixInitiale = prixInitiale;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public boolean isEtatVente() {
		return etatVente;
	}
	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres
				+ ", prixInitiale=" + prixInitiale + ", prixVente=" + prixVente + ", etatVente=" + etatVente
				+ ", noUtilisateur=" + noUtilisateur + ", noCategorie=" + noCategorie + ", pseudo=" + pseudo + "]";
	}



	
	
	
}
