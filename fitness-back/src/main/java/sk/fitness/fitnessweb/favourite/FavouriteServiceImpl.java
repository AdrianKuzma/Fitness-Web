package sk.fitness.fitnessweb.favourite;

import org.springframework.stereotype.Service;
import sk.fitness.fitnessweb.article.Category;
import sk.fitness.fitnessweb.user.User;
import sk.fitness.fitnessweb.user.UserService;

@Service
public class FavouriteServiceImpl implements FavouriteService {
    private FavouriteRepository repository;
    private UserService userService;

    public FavouriteServiceImpl(FavouriteRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public void createNewFavouriteList(User user) {
        Favourite favourite = new Favourite();
        favourite.setUser(user);
        repository.save(favourite);
    }
}
