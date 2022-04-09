package sk.fitness.fitnessweb.article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getAllArticles();
    Optional<Article> getArticleById(long id);
    List<Article> getArticleByType(ArticleType type);
    List<Article> getExercisesFromCategory(Category category);
    List<Category> getCategories();
}
