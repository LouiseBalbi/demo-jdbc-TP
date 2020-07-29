package lectureFichier;

import java.util.ArrayList;
import java.util.Set;

import entites.Ingredient;

public class Split {
	
	public static ArrayList<Ingredient> splitIngredients(String morceaux){
		
		String[] lignes = morceaux.split("\\,", -1);
		
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();	
		
		for (int i = 1; i < lignes.length; i++) {
			list.add(new Ingredient(i, lignes[i].trim()));
			
		}
		return list;
	}

	
	
	
	
}
