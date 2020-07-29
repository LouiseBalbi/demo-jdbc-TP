package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entites.Ingredient;
import entites.Marque;

public class IngredientDaoJdbc implements IngredientDao {

//	@Override
//	public List<Ingredient> extraire() {
//		Connection connection = null;
//		List<Ingredient> listeIngredient = new ArrayList<Ingredient>();
//		try {
//			connection = getConnection(); // jeton de permission et d'accès à la base
//			
//			// récupérer un buffer d'échange avec la BDD (un tuyau de communication)
//			Statement monCanal = connection.createStatement();
//			ResultSet monResultat = monCanal.executeQuery("select * from ingredient;");
//			
//			while(monResultat.next()) {
//				listeIngredient.add(new Ingredient(monResultat.getInt("id_ing"), 
//											monResultat.getString("nom")));
//			}
//			monResultat.close();
//			monCanal.close();
//			
//		} catch(Exception e) {
//			System.err.println("Erreur d'éxecution :" + e.getMessage());
//		} finally {
//			try {
//				if(connection != null) connection.close();
//			} catch(SQLException e) {
//				System.err.println("Problème de connection :" + e.getMessage());
//			}		
//		}
//		return listeIngredient;
//	}

	@Override
	public void insert(Ingredient ingredient) {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			int nb = monCanal.executeUpdate("insert into ingredient (nom) values('" 
					+ ingredient.getNom() + "')");

			monCanal.close();
			connection.close();
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
			} catch(SQLException e) {
				System.err.println("Problème de connection :" + e.getMessage());
			}		
		}

	}
	
	
	public int getIngredientIdByName(String nom) {
		Connection connection = null;
		int id_ing = -1;
		try {
			connection = getConnection();			
			Statement monCanal = connection.createStatement();
			ResultSet res = monCanal.executeQuery(
					"SELECT id_ing FROM ingredient WHERE nom='" + nom + "'");
			
			if (res.next()) {
				id_ing = res.getInt("id_ing");
				
			} 
			monCanal.close();
			connection.close();
		
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}
		return id_ing;
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		Connection connection = null;
		int nb = 0;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			nb = monCanal.executeUpdate("update ingredient SET nom = '" 
										+ nouveauNom+ "'where nom ='" 
										+ancienNom+"';");

			monCanal.close();
			connection.close();
		
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
			} catch(SQLException e) {
				System.err.println("Problème de connection :" + e.getMessage());
			}		
		}
		return nb;
	}

	@Override
	public boolean delete(Ingredient ingredient) {
		Connection connection = null;
		boolean nb = false;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			if(monCanal.executeUpdate("delete from ingredient where id = " + ingredient.getId_ing()+ ";")
					==1) {
				nb = true;
			}
			monCanal.close();
			connection.close();	
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
			} catch(SQLException e) {
				System.err.println("Problème de connection :" + e.getMessage());
			}		
		}
		return nb;
	}
	
	
	public Connection getConnection() {
		// recupere le fichier properties
		ResourceBundle db = ResourceBundle.getBundle("database");

		try {
			// enregistre le pilote
			Class.forName(db.getString("db.driver"));

			return DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
					db.getString("db.pass"));
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException();
		}
	}

}
