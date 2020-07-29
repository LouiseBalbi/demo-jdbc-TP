package dao;

import java.util.List;

import entites.Additif;

public interface AdditifDao {
	
	//List<Additif> extraire();
	void insert(Additif additif);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Additif additif);

}
