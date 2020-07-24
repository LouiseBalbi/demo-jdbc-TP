package exemple.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import exemple.jdbc.entity.Fournisseur;
import fr.diginamic.jdbc.exception.ComptaException;

public class FournisseurDaoJdbc implements FournisseurDao {
	

	@Override
	public List<Fournisseur> extraire() {
		Connection connection = null;
		List<Fournisseur> listeFour = new ArrayList<Fournisseur>();
		try {
			connection = getConnection();
			/** Récupérer un statement = accès aux données à partir de l'objet connection
			 * Récupérer le Resultat de la requête
			 * Ajouter ligne par ligne dans la liste des Fournisseurs
			 */
			
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


	}

	/** fait un update dans la table fournisseur en changeant le nom ancienNom par nouveauNom*/
	@Override
	public int update(String ancienNom, String nouveauNom) {

		return 0;
	}
	
	/** supprime le fournisseur specifie dans la table fournisseur */
	@Override
	public boolean delete(Fournisseur fournisseur) {

		return false;
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
