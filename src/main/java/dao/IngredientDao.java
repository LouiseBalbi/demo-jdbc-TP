package dao;

import java.util.List;

import entites.Ingredient;

public interface IngredientDao {

	//List<Ingredient> extraire();
	void insert(Ingredient ingredient);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Ingredient ingredient);
}
