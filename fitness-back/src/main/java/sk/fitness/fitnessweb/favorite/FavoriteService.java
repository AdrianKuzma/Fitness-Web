package sk.fitness.fitnessweb.favorite;

import sk.fitness.fitnessweb.article.Article;
import sk.fitness.fitnessweb.article.ArticleType;

import java.util.List;

public interface FavoriteService {
    Article addArticleToFavourites(Long articleId);
    void removeArticleFromFavorites(Long articleId);
    List<Article> getAllFavoriteArticles();
    List<Article> getFavoriteArticlesByType(ArticleType articleType);
}
