package entites;

import java.util.ArrayList;
import java.util.List;

public class Produit {
	
	private int id_prod;
	private Categorie categorie;
	private Marque marque;
	private String nom;
	private String nutritionGrade;
	private double energie100g;
	private double graisse100g;
	private double sucres100g;
	private double fibres100g;
	private double proteine100g;
	private double sel100g;
	private double vitA;
	private double vitD;
	private double vitE;
	private double vitK;
	private double vitC;
	private double vitB1;
	private double vitB2;
	private double vitPP;
	private double vitB6;
	private double vitB9;
	private double vitB121;
	private double calcium;
	private double magnesium;
	private double iron;
	private double fer;
	private double betacarotene;
	private boolean huileDePalme;
	private List<Allergene> listeAllergnes = new ArrayList<Allergene>();
	private List<Additif> listeAdditifs = new ArrayList<Additif>();
	private List<Ingredient> listeIngredients = new ArrayList<Ingredient>();
	/**
	 * @param id_prod
	 * @param categorie
	 * @param marque
	 * @param nom
	 * @param nutritionGrade
	 * @param energie100g
	 * @param graisse100g
	 * @param sucres100g
	 * @param fibres100g
	 * @param proteine100g
	 * @param sel100g
	 * @param vitA
	 * @param vitD
	 * @param vitE
	 * @param vitK
	 * @param vitC
	 * @param vitB1
	 * @param vitB2
	 * @param vitPP
	 * @param vitB6
	 * @param vitB9
	 * @param vitB121
	 * @param calcium
	 * @param magnesium
	 * @param iron
	 * @param fer
	 * @param betacarotene
	 * @param huileDePalme
	 * @param listeAllergnes
	 * @param listeAdditifs
	 * @param listeIngredients
	 * 	
	 */
	
	public Produit(String nom) {
		this.nom = nom;
	}
	
	public Produit(int id_prod, Categorie categorie, Marque marque, String nom, String nutritionGrade,
			double energie100g, double graisse100g, double sucres100g, double fibres100g, double proteine100g,
			double sel100g, double vitA, double vitD, double vitE, double vitK, double vitC, double vitB1, double vitB2,
			double vitPP, double vitB6, double vitB9, double vitB121, double calcium, double magnesium, double iron,
			double fer, double betacarotene, boolean huileDePalme, List<Allergene> listeAllergnes,
			List<Additif> listeAdditifs, List<Ingredient> listeIngredients) {
		super();
		this.id_prod = id_prod;
		this.categorie = categorie;
		this.marque = marque;
		this.nom = nom;
		this.nutritionGrade = nutritionGrade;
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteine100g = proteine100g;
		this.sel100g = sel100g;
		this.vitA = vitA;
		this.vitD = vitD;
		this.vitE = vitE;
		this.vitK = vitK;
		this.vitC = vitC;
		this.vitB1 = vitB1;
		this.vitB2 = vitB2;
		this.vitPP = vitPP;
		this.vitB6 = vitB6;
		this.vitB9 = vitB9;
		this.vitB121 = vitB121;
		this.calcium = calcium;
		this.magnesium = magnesium;
		this.iron = iron;
		this.fer = fer;
		this.betacarotene = betacarotene;
		this.huileDePalme = huileDePalme;
		this.listeAllergnes = listeAllergnes;
		this.listeAdditifs = listeAdditifs;
		this.listeIngredients = listeIngredients;
	}
	/**
	 * @return the id_prod
	 */
	public int getId_prod() {
		return id_prod;
	}
	/**
	 * @param id_prod the id_prod to set
	 */
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/**
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}
	/**
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
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
	/**
	 * @return the nutritionGrade
	 */
	public String getNutritionGrade() {
		return nutritionGrade;
	}
	/**
	 * @param nutritionGrade the nutritionGrade to set
	 */
	public void setNutritionGrade(String nutritionGrade) {
		this.nutritionGrade = nutritionGrade;
	}
	/**
	 * @return the energie100g
	 */
	public double getEnergie100g() {
		return energie100g;
	}
	/**
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(double energie100g) {
		this.energie100g = energie100g;
	}
	/**
	 * @return the graisse100g
	 */
	public double getGraisse100g() {
		return graisse100g;
	}
	/**
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(double graisse100g) {
		this.graisse100g = graisse100g;
	}
	/**
	 * @return the sucres100g
	 */
	public double getSucres100g() {
		return sucres100g;
	}
	/**
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(double sucres100g) {
		this.sucres100g = sucres100g;
	}
	/**
	 * @return the fibres100g
	 */
	public double getFibres100g() {
		return fibres100g;
	}
	/**
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(double fibres100g) {
		this.fibres100g = fibres100g;
	}
	/**
	 * @return the proteine100g
	 */
	public double getProteine100g() {
		return proteine100g;
	}
	/**
	 * @param proteine100g the proteine100g to set
	 */
	public void setProteine100g(double proteine100g) {
		this.proteine100g = proteine100g;
	}
	/**
	 * @return the sel100g
	 */
	public double getSel100g() {
		return sel100g;
	}
	/**
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(double sel100g) {
		this.sel100g = sel100g;
	}
	/**
	 * @return the vitA
	 */
	public double getVitA() {
		return vitA;
	}
	/**
	 * @param vitA the vitA to set
	 */
	public void setVitA(double vitA) {
		this.vitA = vitA;
	}
	/**
	 * @return the vitD
	 */
	public double getVitD() {
		return vitD;
	}
	/**
	 * @param vitD the vitD to set
	 */
	public void setVitD(double vitD) {
		this.vitD = vitD;
	}
	/**
	 * @return the vitE
	 */
	public double getVitE() {
		return vitE;
	}
	/**
	 * @param vitE the vitE to set
	 */
	public void setVitE(double vitE) {
		this.vitE = vitE;
	}
	/**
	 * @return the vitK
	 */
	public double getVitK() {
		return vitK;
	}
	/**
	 * @param vitK the vitK to set
	 */
	public void setVitK(double vitK) {
		this.vitK = vitK;
	}
	/**
	 * @return the vitC
	 */
	public double getVitC() {
		return vitC;
	}
	/**
	 * @param vitC the vitC to set
	 */
	public void setVitC(double vitC) {
		this.vitC = vitC;
	}
	/**
	 * @return the vitB1
	 */
	public double getVitB1() {
		return vitB1;
	}
	/**
	 * @param vitB1 the vitB1 to set
	 */
	public void setVitB1(double vitB1) {
		this.vitB1 = vitB1;
	}
	/**
	 * @return the vitB2
	 */
	public double getVitB2() {
		return vitB2;
	}
	/**
	 * @param vitB2 the vitB2 to set
	 */
	public void setVitB2(double vitB2) {
		this.vitB2 = vitB2;
	}
	/**
	 * @return the vitPP
	 */
	public double getVitPP() {
		return vitPP;
	}
	/**
	 * @param vitPP the vitPP to set
	 */
	public void setVitPP(double vitPP) {
		this.vitPP = vitPP;
	}
	/**
	 * @return the vitB6
	 */
	public double getVitB6() {
		return vitB6;
	}
	/**
	 * @param vitB6 the vitB6 to set
	 */
	public void setVitB6(double vitB6) {
		this.vitB6 = vitB6;
	}
	/**
	 * @return the vitB9
	 */
	public double getVitB9() {
		return vitB9;
	}
	/**
	 * @param vitB9 the vitB9 to set
	 */
	public void setVitB9(double vitB9) {
		this.vitB9 = vitB9;
	}
	/**
	 * @return the vitB121
	 */
	public double getVitB121() {
		return vitB121;
	}
	/**
	 * @param vitB121 the vitB121 to set
	 */
	public void setVitB121(double vitB121) {
		this.vitB121 = vitB121;
	}
	/**
	 * @return the calcium
	 */
	public double getCalcium() {
		return calcium;
	}
	/**
	 * @param calcium the calcium to set
	 */
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	/**
	 * @return the magnesium
	 */
	public double getMagnesium() {
		return magnesium;
	}
	/**
	 * @param magnesium the magnesium to set
	 */
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	/**
	 * @return the iron
	 */
	public double getIron() {
		return iron;
	}
	/**
	 * @param iron the iron to set
	 */
	public void setIron(double iron) {
		this.iron = iron;
	}
	/**
	 * @return the fer
	 */
	public double getFer() {
		return fer;
	}
	/**
	 * @param fer the fer to set
	 */
	public void setFer(double fer) {
		this.fer = fer;
	}
	/**
	 * @return the betacarotene
	 */
	public double getBetacarotene() {
		return betacarotene;
	}
	/**
	 * @param betacarotene the betacarotene to set
	 */
	public void setBetacarotene(double betacarotene) {
		this.betacarotene = betacarotene;
	}
	/**
	 * @return the huileDePalme
	 */
	public boolean isHuileDePalme() {
		return huileDePalme;
	}
	/**
	 * @param huileDePalme the huileDePalme to set
	 */
	public void setHuileDePalme(boolean huileDePalme) {
		this.huileDePalme = huileDePalme;
	}
	/**
	 * @return the listeAllergnes
	 */
	public List<Allergene> getListeAllergnes() {
		return listeAllergnes;
	}
	/**
	 * @param listeAllergnes the listeAllergnes to set
	 */
	public void setListeAllergnes(List<Allergene> listeAllergnes) {
		this.listeAllergnes = listeAllergnes;
	}
	/**
	 * @return the listeAdditifs
	 */
	public List<Additif> getListeAdditifs() {
		return listeAdditifs;
	}
	/**
	 * @param listeAdditifs the listeAdditifs to set
	 */
	public void setListeAdditifs(List<Additif> listeAdditifs) {
		this.listeAdditifs = listeAdditifs;
	}
	/**
	 * @return the listeIngredients
	 */
	public List<Ingredient> getListeIngredients() {
		return listeIngredients;
	}
	/**
	 * @param listeIngredients the listeIngredients to set
	 */
	public void setListeIngredients(List<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	

	
}
