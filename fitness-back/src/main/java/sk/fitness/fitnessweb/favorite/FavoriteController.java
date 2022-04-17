package sk.fitness.fitnessweb.favorite;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fitness.fitnessweb.article.Article;
import sk.fitness.fitnessweb.article.ArticleType;
import sk.fitness.fitnessweb.dto.GetArticleDto;
import sk.fitness.fitnessweb.exception.AlreadyFavoriteException;
import sk.fitness.fitnessweb.exception.ArticleNotFoundException;
import sk.fitness.fitnessweb.exception.NotFavoriteException;

import java.util.List;

@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/favorites")
    public List<GetArticleDto> getFavorites(@RequestParam(required = false) ArticleType articleType) {
        return GetArticleDto.wrap(
                articleType != null
                        ? favoriteService.getFavoriteArticlesByType(articleType)
                        : favoriteService.getAllFavoriteArticles()
        );
    }

    @PostMapping("/favorites/{id}")
    public ResponseEntity<GetArticleDto> addToFavorites(@PathVariable Long id){
        try {
            Article article = favoriteService.addArticleToFavourites(id);
            return ResponseEntity.ok(GetArticleDto.wrap(article));
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (AlreadyFavoriteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<?> removeFromFavorites(@PathVariable Long id){
        try {
            favoriteService.removeArticleFromFavorites(id);
            return ResponseEntity.noContent().build();
        } catch (NotFavoriteException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
