package exemple.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import exemple.jdbc.entity.Fournisseur;
import fr.diginamic.jdbc.exception.ComptaException;

public class FournisseurDaoJdbc implements FournisseurDao {
	
	public static void main(String[] a) {
		FournisseurDaoJdbc ofo = new FournisseurDaoJdbc();
		List<Fournisseur> listeFour = ofo.extraire();
		for(Fournisseur fo : listeFour) {
			System.out.println(fo);
		}
		// ofo.insert(new Fournisseur(9, "Lessieurs"));
		ofo.update("Lessieurs", "Leclerc");
		listeFour = ofo.extraire();
		for(Fournisseur fo : listeFour) {
			System.out.println(fo);
		}
		ofo.delete(new Fournisseur(9, "Leclerc"));
		System.out.println("Fournisseur supprimé !");
		listeFour = ofo.extraire();
		for(Fournisseur fo : listeFour) {
			System.out.println(fo);
		}
	}
	

	@Override
	public List<Fournisseur> extraire() {
		Connection connection = null;
		List<Fournisseur> listeFour = new ArrayList<Fournisseur>();
		try {
			connection = getConnection(); // jeton de permission et d'accès à la base
			/** Récupérer un statement = accès aux données à partir de l'objet connection
			 * Récupérer le Resultat de la requête
			 * Ajouter ligne par ligne dans la liste des Fournisseurs
			 */
			
			// récupérer un buffer d'échange avec la BDD (un tuyau de communication)
			Statement monCanal = connection.createStatement();
			ResultSet monResultat = monCanal.executeQuery("select * from fournisseur;");
			
			while(monResultat.next()) {
				listeFour.add(new Fournisseur(monResultat.getInt("id"), monResultat.getString("nom")));
			}
			monResultat.close();
			monCanal.close();
			
		} catch(Exception e) {
			System.err.println("Erreur d'éxecution :" + e.getMessage());
		} finally {
			try {
				if(connection != null) connection.close();
			} catch(SQLException e) {
				System.err.println("Problème de connection :" + e.getMessage());
			}		
		}
		return listeFour;
	}

	
	/** fait un insert dans la base de compta sur la table fournisseur*/
	@Override
	public void insert(Fournisseur fournisseur) {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			int nb = monCanal.executeUpdate("insert into fournisseur (id, nom) values(" + fournisseur.getId() + ",'"
					+ fournisseur.getNom() + "');");
			if(nb == 1) {
				System.out.println("Fournisseur ajouté !");
			}
			monCanal.close();
			
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

	/** fait un update dans la table fournisseur en changeant le nom ancienNom par nouveauNom*/
	@Override
	public int update(String ancienNom, String nouveauNom) {
		Connection connection = null;
		int nb = 0;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			nb = monCanal.executeUpdate("update fournisseur SET nom = '" 
										+ nouveauNom+ "'where nom ='" 
										+ancienNom+"';");

			monCanal.close();
			
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
	
	/** supprime le fournisseur specifie dans la table fournisseur */
	@Override
	public boolean delete(Fournisseur fournisseur) {
		Connection connection = null;
		boolean nb = false;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			if(monCanal.executeUpdate("delete from fournisseur where id = " + fournisseur.getId()+ ";")
					==1) {
				nb = true;
			}
			monCanal.close();
			
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
