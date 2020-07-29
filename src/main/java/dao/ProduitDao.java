package dao;

import java.util.List;

import entites.Allergene;
import entites.Produit;

public interface ProduitDao {
	
	void insert(Produit produit);
	int update(Produit ancienProduit, Produit nouveauProduit);


}
