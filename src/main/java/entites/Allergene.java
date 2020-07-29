package entites;

public class Allergene {
	
	private int id_all;
	private String nom;
	
	/**
	 * @param id_all
	 * @param nom
	 */
	public Allergene(int id_all, String nom) {
		super();
		this.id_all = id_all;
		this.nom = nom;
	}
	
	public Allergene(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the id_all
	 */
	public int getId_all() {
		return id_all;
	}

	/**
	 * @param id_all the id_all to set
	 */
	public void setId_all(int id_all) {
		this.id_all = id_all;
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
