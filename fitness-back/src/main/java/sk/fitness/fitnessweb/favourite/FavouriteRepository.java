package sk.fitness.fitnessweb.favourite;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fitness.fitnessweb.user.User;

public interface FavouriteRepository extends JpaRepository<Favourite,Long> {
    Favourite findByUser(User user);
}
