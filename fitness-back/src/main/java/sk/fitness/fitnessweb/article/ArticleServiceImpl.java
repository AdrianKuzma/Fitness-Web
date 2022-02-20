package sk.fitness.fitnessweb.article;

import org.springframework.stereotype.Service;
import sk.fitness.fitnessweb.favourite.Favourite;
import sk.fitness.fitnessweb.favourite.FavouriteRepository;
import sk.fitness.fitnessweb.user.User;
import sk.fitness.fitnessweb.user.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;
    private FavouriteRepository favouriteRepository;
    private UserService userService;

    public ArticleServiceImpl(ArticleRepository repository, FavouriteRepository favouriteRepository, UserService userService) {
        this.repository = repository;
        this.favouriteRepository = favouriteRepository;
        this.userService = userService;
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

    @Override
    public List<Article> getExercisesFromCategory(Category category) {
        return this.repository.findByCategory(category);
    }

    @Override
    public List<Category> getCategories() {
        return Arrays.asList(Category.values().clone());
    }

    @Override
    public void addToFavourites(Long id) {
        Article article = repository.findById(id).get();
        Favourite favourite = favouriteRepository.findByUser(userService.getCurrentUser());
        favourite.setArticles(article);
        favouriteRepository.save(favourite);
    }

    @Override
    public List<Article> getFavouritesArticles() {
        return favouriteRepository.findByUser(userService.getCurrentUser()).getArticles();
    }


}
