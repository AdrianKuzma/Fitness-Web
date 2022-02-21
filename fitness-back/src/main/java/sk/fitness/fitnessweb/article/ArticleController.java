package sk.fitness.fitnessweb.article;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getArticles(@RequestParam(required = false) ArticleType type) {
        if (type != null) {
            return this.articleService.getArticleByType(type);
        }
        return this.articleService.getAllArticles();
    }

    @GetMapping("{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id) {
        return ResponseEntity.of(this.articleService.getArticleById(id));
    }

    @GetMapping("/exercises/category")
    public List<Article> getExercisesFromCategory(@RequestParam(required = false) Category category){
        if(category != null){
            return this.articleService.getExercisesFromCategory(category);
        }
        return this.articleService.getArticleByType(ArticleType.EXERCISES);
    }

    @GetMapping("/exercises/allCategories")
    public List<Category> getListOfCategories(){
        return articleService.getCategories();
    }

    @GetMapping("/favouritesArticles")
    public List<Article> getFavourites(){
        return articleService.getFavouritesArticles();
    }

    @PostMapping("/addToFavourite")
    public void addToFavourites(@RequestParam Long id){
        articleService.addToFavourites(id);
    }

    @DeleteMapping("/delete/{id}")
    public Article deleteArticleFromFavourites(@PathVariable Long id){
        return articleService.deleteArticleFromFavourites(id);
    }
}
