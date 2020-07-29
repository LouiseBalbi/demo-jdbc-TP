package lectureFichier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import dao.AdditifDaoJdbc;
import dao.AllergeneDaoJdbc;
import dao.CategorieDaoJdbc;
import dao.IngredientDaoJdbc;
import dao.MarqueDaoJdbc;
import dao.ProduitDaoJdbc;
import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;

public class Application {

	public static void main(String[] args) {
		
//		Allergene catTest = new Allergene("cat");
//		AllergeneDaoJdbc catDao = new AllergeneDaoJdbc();
//		catDao.insert(catTest);
//		System.out.println(catDao.getAllergeneIdByName("tot"));
		
//		ProduitDaoJdbc catTest = new ProduitDaoJdbc();
//		catTest.insertJointureIng(3, 2);

		
		
		
		try {
			File file = new File("C:\\Users\\louis\\Desktop\\Diginamic\\openFoodFacts.csv");
		List<String> lignes = FileUtils.readLines(file, "UTF-8");

		lignes.remove(0);

		for (String ligne : lignes) {
			
			List<Produit> listeProduits = new ArrayList<>();
			
			// les lignes sont s�par�es en diff�rents morceaux
			String[] morceaux = ligne.split("\\|", -1);
			
			String nomCategorie = morceaux[0];
			String nomMarque = morceaux[1];
			String nom = morceaux[2];
			String nutritionGrade = morceaux[3];

			String ingredientsStr = morceaux[4];
			List<String> ingredients = Arrays.asList(ingredientsStr.split(",", -1));
			List<Ingredient> listeIngredients = new ArrayList<>();
			
			Double energie100g =  StringUtils.toDouble(morceaux[5]);
			Double graisse100g = StringUtils.toDouble(morceaux[6]);
			Double sucres100g = StringUtils.toDouble(morceaux[7]);
			Double fibres100g = StringUtils.toDouble(morceaux[8]);
			Double proteines100g = StringUtils.toDouble(morceaux[9]);
			Double sel100g = StringUtils.toDouble(morceaux[10]);
			Double vitA = StringUtils.toDouble(morceaux[11]);
			Double vitD = StringUtils.toDouble(morceaux[12]);
			Double vitE = StringUtils.toDouble(morceaux[13]);
			Double vitK = StringUtils.toDouble(morceaux[14]);
			Double vitC = StringUtils.toDouble(morceaux[15]);
			Double vitB1 = StringUtils.toDouble(morceaux[16]);
			Double vitB2 = StringUtils.toDouble(morceaux[17]);
			Double vitPP = StringUtils.toDouble(morceaux[18]);
			Double vitB6 = StringUtils.toDouble(morceaux[19]);
			Double vitB9 = StringUtils.toDouble(morceaux[20]);
			Double vitB121 = StringUtils.toDouble(morceaux[21]);
			Double calcium = StringUtils.toDouble(morceaux[22]);
			Double magnesium = StringUtils.toDouble(morceaux[23]);
			Double iron = StringUtils.toDouble(morceaux[24]);
			Double fer = StringUtils.toDouble(morceaux[25]);
			Double betacarotene = StringUtils.toDouble(morceaux[26]);
			String huileDePalme = morceaux[27];
			
			String allergenesStr = morceaux[28];
			List<String> allergenes = Arrays.asList(allergenesStr.split(",", -1));
			List<Allergene> listeAllergenes = new ArrayList<>();
			
			
			String additifsStr = morceaux[29];
			List<String> additifs = Arrays.asList(additifsStr.split(",", -1));
			List<Additif> listeAdditifs = new ArrayList<>();
			
			
			Produit produit = new Produit(StringUtils.traitementCaracteresSpe(nom));
			produit.setCategorie(new Categorie(StringUtils.traitementCaracteresSpe(nomCategorie)));
			produit.setMarque(new Marque(StringUtils.traitementCaracteresSpe(nomMarque)));
			produit.setNutritionGrade(nutritionGrade);
			produit.setEnergie100g(energie100g);
			produit.setGraisse100g(graisse100g);
			produit.setSucres100g(sucres100g);
			produit.setFibres100g(fibres100g);
			produit.setProteine100g(proteines100g);
			produit.setSel100g(sel100g);
			produit.setVitA(vitA);
			produit.setVitD(vitD);
			produit.setVitE(vitE);
			produit.setVitK(vitK);
			produit.setVitC(vitC);
			produit.setVitB1(vitB1);
			produit.setVitB2(vitB2);
			produit.setVitPP(vitPP);
			produit.setVitB6(vitB6);
			produit.setVitB9(vitB9);
			produit.setVitB121(vitB121);
			produit.setCalcium(calcium);
			produit.setMagnesium(magnesium);
			produit.setIron(iron);
			produit.setFer(fer);
			produit.setBetacarotene(betacarotene);
			produit.setListeIngredients(listeIngredients);
			produit.setListeAllergnes(listeAllergenes);
			produit.setListeAdditifs(listeAdditifs);
			produit.setHuileDePalme(Boolean.parseBoolean(huileDePalme));

			ProduitDaoJdbc insererPdt = new ProduitDaoJdbc();
			insererPdt.insert(produit);
			
		}
	
		}catch(IOException e) {
			// traitement des exceptions
			System.out.println(e.getMessage());
		}
		
	


	}

}
