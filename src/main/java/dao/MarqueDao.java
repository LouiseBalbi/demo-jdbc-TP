package dao;

import java.util.List;

import entites.Marque;

public interface MarqueDao {
	
	//List<Marque> extraire();
	void insert(Marque marque);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Marque marque);

}
