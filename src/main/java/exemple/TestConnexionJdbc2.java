package exemple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TestConnexionJdbc2 {

	public static void main(String[] args) {

		// recupere le fichier properties
		ResourceBundle db = ResourceBundle.getBundle("database");
		Connection connection = null;

		try {

			// enregistre le pilote
			Class.forName(db.getString("db.driver"));

			// creer la connection
			connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
					db.getString("db.pass"));

			// affiche la connexion
			boolean valid = connection.isValid(500);
			if (valid) {
				// SEVERE = Erreur
				// INFO = info
				// WARNING = Avertissement
				// FINEST = Debug
				System.out.println("La connection est ok");
			} else {
				System.out.println("Il y a une erreur de connection");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// Handle errors for JDBC
			System.out.println("Erreur de communication avec la base");
		}

		finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println("Erreur de connection : " + e.getMessage());
			}
			System.out.println("Base déconnectée");
		}

	}

}
