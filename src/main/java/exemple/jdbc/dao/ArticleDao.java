package exemple.jdbc.dao;

import java.util.List;

import exemple.jdbc.entity.Article;
import exemple.jdbc.entity.Fournisseur;

public interface ArticleDao {

	List<Article> extraire();
	void insert(Article article);
	int update(String ancienDesignation, String nouveauDesignation);
	boolean delete(Article article);
}
