package entites;

public class Categorie {
	
	private int id_cat;
	private String nom;
	
	/**
	 * @param id_cat
	 * @param nom
	 */
	public Categorie(int id_cat, String nom) {
		super();
		this.id_cat = id_cat;
		this.nom = nom;
	}
	
	public Categorie(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the id_cat
	 */
	public int getId_cat() {
		return id_cat;
	}

	/**
	 * @param id_cat the id_cat to set
	 */
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
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
