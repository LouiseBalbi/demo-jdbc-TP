package entites;

public class Ingredient {
	
	private int id_ing;
	private String nom;
	
	/**
	 * @param id_ing
	 * @param nom
	 */
	
	public Ingredient(String nom) {
		this.nom = nom;
	}
	
	public Ingredient(int id_ing, String nom) {
		super();
		this.id_ing = id_ing;
		this.nom = nom;
	}
	/**
	 * @return the id_ing
	 */
	public int getId_ing() {
		return id_ing;
	}
	/**
	 * @param id_ing the id_ing to set
	 */
	public void setId_ing(int id_ing) {
		this.id_ing = id_ing;
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
