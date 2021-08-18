package bo;

import java.time.LocalDate;
import java.util.Date;

public class Enchere {
	private LocalDate dateEnchere;
	private int montantEnchere;
	private int noUtilisateur;
	
	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	
	public Enchere(LocalDate dateEnchere, int montantEnchere, int noUtilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noUtilisateur = noUtilisateur;
	}

	

	public int getNoUtilisateur() {
		return noUtilisateur;
	}


	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", noUtilisateur="
				+ noUtilisateur + "]";
	}
	
	

}
