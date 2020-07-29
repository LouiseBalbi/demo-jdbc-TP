package entites;

public class Additif {
	
	private int id_add;
	private String nom;
	
	/**
	 * @param id_add
	 * @param nom
	 */
	public Additif(int id_add, String nom) {
		super();
		this.id_add = id_add;
		this.nom = nom;
	}
	
	public Additif(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the id_add
	 */
	public int getId_add() {
		return id_add;
	}

	/**
	 * @param id_add the id_add to set
	 */
	public void setId_add(int id_add) {
		this.id_add = id_add;
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
