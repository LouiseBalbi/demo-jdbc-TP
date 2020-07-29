package exemple.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import exemple.jdbc.entity.Article;
import exemple.jdbc.entity.Fournisseur;

public class ArticleDaoJdbc implements ArticleDao {
	
	public static void main(String[] a) {
		ArticleDaoJdbc art = new ArticleDaoJdbc();
		List<Article> listeArticle = art.extraire();
		for(Article ar : listeArticle) {
			System.out.println(ar);
		}
		System.out.println("--------------");
		
		// art.insert(new Article(11, "B12", "Tournevis", 5.55, 2));
		art.update("Tournevis", "Marteau");
		listeArticle = art.extraire();
		for(Article ar : listeArticle) {
			System.out.println(ar);
		}
		System.out.println("--------------");
		art.delete(new Article(11, "B12", "Marteau", 5.55, 2));
		listeArticle = art.extraire();
		for(Article ar : listeArticle) {
			System.out.println(ar);
		}
				
	}
	
	@Override
	public List<Article> extraire() {
		Connection connection = null;
		List<Article> listeArticle = new ArrayList<Article>();
		try {
			connection = getConnection(); // jeton de permission et d'accès à la base
			
			// récupérer un buffer d'échange avec la BDD (un tuyau de communication)
			Statement monCanal = connection.createStatement();
			ResultSet monResultat = monCanal.executeQuery("select * from article;");
			
			while(monResultat.next()) {
				listeArticle.add(new Article(monResultat.getInt("id"), 
						monResultat.getString("ref"), 
						monResultat.getString("designation"),
						monResultat.getDouble("prix"),
						monResultat.getInt("id_fou")));
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
		return listeArticle;
	}



	@Override
	public void insert(Article article) {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			int nb = monCanal.executeUpdate("insert into article (id, ref, designation, prix, id_fou) values(" 
					+ article.getId() + ",'"
					+ article.getRef() + "' , '"
					+ article.getDesignation() + "' , "
					+ article.getPrix() + ", "
					+ article.getId_fou() + ")"
					);
			if(nb == 1) {
				System.out.println("Article ajouté !");
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

	@Override
	public int update(String ancienDesignation, String nouveauDesignation) {
		Connection connection = null;
		int nb = 0;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			nb = monCanal.executeUpdate("update article SET designation = '" 
										+ nouveauDesignation+ "'where designation ='" 
										+ ancienDesignation+"';");

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

	@Override
	public boolean delete(Article article) {
		Connection connection = null;
		boolean nb = false;
		try {
			connection = getConnection();
			Statement monCanal = connection.createStatement();
			if(monCanal.executeUpdate("delete from article where id = " + article.getId()+ ";")
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
