package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;
import lectureFichier.StringUtils;

public class ProduitDaoJdbc implements ProduitDao {

	int id_prod = -1;

	// récupère ID du produit à partir de son nom
	public int getProduitIdByName(String nom) {
		
		Connection connection = null;
		try {
			connection = getConnection();			
			Statement monCanal = connection.createStatement();
			ResultSet res = monCanal.executeQuery(
					"SELECT id_prod FROM produit WHERE nom='" + nom + "'");
			
			if (res.next()) {
				id_prod = res.getInt("id_prod");
				
			} 
			monCanal.close();
			connection.close();
		
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}
		return id_prod;
	}
	
	


	@Override
	public void insert(Produit produit) {
		
		Connection connection = null;
		
		try {
			
			
			Categorie categorie = produit.getCategorie();
			
			CategorieDaoJdbc cat = new CategorieDaoJdbc();
			int id_cat = cat.getCategorieIdByName(categorie.getNom());
			
			if (id_cat != -1) {
				categorie.setId_cat(id_cat);
				
			} else {
				cat.insert(categorie);
				id_cat = cat.getCategorieIdByName(categorie.getNom());
				categorie.setId_cat(id_cat);
				
				}
			
			
			Marque marque = produit.getMarque();
			
			MarqueDaoJdbc mar = new MarqueDaoJdbc();
			int id_marque = mar.getMarqueIdByName(marque.getNom());
			
			if(id_marque != -1) {
				marque.setId_marque(id_marque);
			} else {
				mar.insert(marque);
				id_marque = mar.getMarqueIdByName(marque.getNom());
				marque.setId_marque(id_marque);				
			}
			
			

			
			connection = getConnection();
		
			Statement monCanal = connection.createStatement();
			
			if (id_prod == -1) {
			
			int nb = monCanal.executeUpdate("insert into produit (id_cat, id_mar, nom, nutritionGrade, "
									+ "energie100g, graisse100g, sucres100g, fibres100g, proteines100g, sel100g,"
									+ "vitA_100g, vitD_100g, vitE_100g, vitK_100g, vitC_100g, vitB1_100g, vitB2_100g, "
									+ "vitPP_100g, vitB6_100g, vitB9_100g, vitB121_100g, calcium100g, magnesium100g,"
									+ "iron100g, fer100g, betacarotene100g, huileDePalme) "
					+ "values(" 
					+ produit.getCategorie().getId_cat() + ","
					+ produit.getMarque().getId_marque() + ",'"
					+ produit.getNom() + "','"
					+ produit.getNutritionGrade() + "',"
					+ produit.getEnergie100g() + ","
					+ produit.getGraisse100g() + ","
					+ produit.getSucres100g() + ","
					+ produit.getFibres100g() + ","
					+ produit.getProteine100g() + ","
					+ produit.getSel100g() + ","
					+ produit.getVitA() + ","
					+ produit.getVitD() + ","
					+ produit.getVitE() + ","
					+ produit.getVitK() + ","
					+ produit.getVitC() + ","
					+ produit.getVitB1() + ","
					+ produit.getVitB2() + ","
					+ produit.getVitPP() + ","
					+ produit.getVitB6() + ","
					+ produit.getVitB9() + ","
					+ produit.getVitB121() + ","
					+ produit.getCalcium() + ","
					+ produit.getMagnesium() + ","
					+ produit.getIron() + ","
					+ produit.getFer() + ","
					+ produit.getBetacarotene() + ","
					+ produit.isHuileDePalme() + ")");

			
			id_prod = this.getProduitIdByName(produit.getNom());
			IngredientDaoJdbc ing = new IngredientDaoJdbc();
			List<Ingredient> ingredients = produit.getListeIngredients();
			
			// parcours de la liste d'ingrédient et ajout des ingrédients aux tables ingrédients + jointure
			for (Ingredient ingredient : ingredients) {
				int id_ing = ing.getIngredientIdByName(ingredient.getNom());
				if(id_ing != -1) {
					this.insertJointureIng(id_prod, id_ing);
				}else {
					ing.insert(ingredient);
					id_ing = ing.getIngredientIdByName(ingredient.getNom());
					this.insertJointureIng(id_prod, id_ing);
					
				}
			}
			
			
			AllergeneDaoJdbc all = new AllergeneDaoJdbc();
			List<Allergene> allergenes = produit.getListeAllergnes();
			
			// parcours de la liste d'allergene et ajout des allergene aux tables allergene + jointure
			for (Allergene allergene : allergenes) {
				int id_all = all.getAllergeneIdByName(allergene.getNom());
				if(id_all != -1) {
					this.insertJointureAll(id_all, id_prod);
				}else {
					all.insert(allergene);
					id_all = all.getAllergeneIdByName(allergene.getNom());
					this.insertJointureAll(id_all, id_prod);
					
				}
			}
			
			
			AdditifDaoJdbc add = new AdditifDaoJdbc();
			List<Additif> additifs = produit.getListeAdditifs();
			
			// parcours de la liste d'additifs et ajout des additifs aux tables additifs + jointure
			for (Additif additif : additifs) {
				int id_add = add.getAdditifIdByName(additif.getNom());
				if(id_add != -1) {
					this.insertJointureAdd(id_add, id_prod);
				}else {
					add.insert(additif);
					id_add = add.getAdditifIdByName(additif.getNom());
					this.insertJointureAdd(id_add, id_prod);
					
				}
			}
			
			monCanal.close();
			connection.close();
			}
			
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
	
	
	// insertion dans la table jointure entre produit et ingredient
	public void insertJointureIng(int id_prod, int id_ing) {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			int nb = monCanal.executeUpdate("insert into jointure_prod_ing (id_prod, id_ing) values(" 
											+ id_prod + id_ing + ")");

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
	
	
	
	// insertion dans la table jointure entre produit et allergene
	public void insertJointureAll(int id_all, int id_prod) {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			int nb = monCanal.executeUpdate("insert into jointure_prod_all (id_all, id_prod) values(" 
											+ id_all + id_prod + ")");

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
	

	// insertion dans la table jointure entre produit et allergene
	public void insertJointureAdd(int id_add, int id_prod) {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			int nb = monCanal.executeUpdate("insert into jointure_prod_add (id_add, id_prod) values(" 
											+ id_add + id_prod + ")");

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
	


	@Override
	public int update(Produit ancienProduit, Produit nouveauProduit) {
		// TODO Auto-generated method stub
		return 0;
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
