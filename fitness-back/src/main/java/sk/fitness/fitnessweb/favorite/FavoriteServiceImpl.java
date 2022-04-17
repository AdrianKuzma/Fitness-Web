package sk.fitness.fitnessweb.favorite;

import org.springframework.stereotype.Service;
import sk.fitness.fitnessweb.article.Article;
import sk.fitness.fitnessweb.article.ArticleService;
import sk.fitness.fitnessweb.article.ArticleType;
import sk.fitness.fitnessweb.exception.AlreadyFavoriteException;
import sk.fitness.fitnessweb.exception.ArticleNotFoundException;
import sk.fitness.fitnessweb.exception.NotFavoriteException;
import sk.fitness.fitnessweb.user.User;
import sk.fitness.fitnessweb.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final ArticleService articleService;
    private final UserService userService;

    public FavoriteServiceImpl(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @Override
    public Article addArticleToFavourites(Long articleId) {
        Article article = this.articleService.getArticleById(articleId)
                .orElseThrow(ArticleNotFoundException::new);

        User user = this.userService.getCurrentUser();
        this.throwIfAlreadyHasFavorite(user, articleId);

        user.getFavorites().add(article);
        this.userService.saveUser(user);

        return article;
    }

    private void throwIfAlreadyHasFavorite(User user, Long articleId) {
        boolean hasFavorite = user.getFavorites().stream()
                .anyMatch(article -> article.getId() == articleId);

        if (hasFavorite) {
            throw new AlreadyFavoriteException();
        }
    }

    @Override
    public void removeArticleFromFavorites(Long articleId) {
        User user = this.userService.getCurrentUser();
        boolean removed = user.getFavorites().removeIf(article -> article.getId() == articleId);

        if (!removed) {
            throw new NotFavoriteException();
        }

        this.userService.saveUser(user);
    }

    @Override
    public List<Article> getAllFavoriteArticles() {
        return this.userService.getCurrentUser().getFavorites();
    }

    @Override
    public List<Article> getFavoriteArticlesByType(ArticleType articleType) {
        return this.userService.getCurrentUser().getFavorites().stream()
                .filter(article -> article.getType().equals(articleType))
                .collect(Collectors.toList());
    }

}
