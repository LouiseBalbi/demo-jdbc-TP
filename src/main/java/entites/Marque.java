package entites;

public class Marque {
	
	private int id_marque;
	private String nom;
	
	/**
	 * @param id_marque
	 * @param nom
	 */
	public Marque(int id_marque, String nom) {
		super();
		this.id_marque = id_marque;
		this.nom = nom;
	}
	
	public Marque(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the id_marque
	 */
	public int getId_marque() {
		return id_marque;
	}
	/**
	 * @param id_marque the id_marque to set
	 */
	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	

}
