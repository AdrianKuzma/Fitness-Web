package sk.fitness.fitnessweb.article;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;

    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Article> getAllArticles() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Article> getArticleById(long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Article> getArticleByType(ArticleType type) {
        return this.repository.findByType(type);
    }

}
