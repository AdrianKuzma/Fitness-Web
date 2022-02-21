package sk.fitness.fitnessweb.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByType(ArticleType type);

    List<Article> findByCategory(Category category);

}
