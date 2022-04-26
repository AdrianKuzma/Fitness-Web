package sk.fitness.fitnessweb.dto;

import org.springframework.security.core.context.SecurityContextHolder;
import sk.fitness.fitnessweb.article.Article;
import sk.fitness.fitnessweb.article.ArticleType;

import java.util.List;
import java.util.stream.Collectors;

public class GetArticleDto {

    private final Article article;

    private GetArticleDto(Article article) {
        this.article = article;
    }

    public Long getId() {
        return this.article.getId();
    }

    public String getName() {
        return this.article.getName();
    }

    public String getDescription() {
        return this.article.getDescription();
    }

    public ArticleType getType() {
        return this.article.getType();
    }

    public String getImage() {
        return this.article.getImage();
    }

    public boolean isFavorite() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (username == null || username.length() == 0) {
            return false;
        }

        return this.article.getFavoriteUsers().stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    public String getRedirectUrl() {
        return this.article.getRedirectUrl();
    }

    public static GetArticleDto wrap(Article article) {
        return new GetArticleDto(article);
    }

    public static List<GetArticleDto> wrap(List<Article> articles) {
        return articles.stream()
                .map(GetArticleDto::new)
                .collect(Collectors.toList());
    }

}
