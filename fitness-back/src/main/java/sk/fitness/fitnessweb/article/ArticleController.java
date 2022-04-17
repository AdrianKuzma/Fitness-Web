package sk.fitness.fitnessweb.article;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.fitness.fitnessweb.dto.GetArticleDto;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<GetArticleDto> getArticles(@RequestParam(required = false) ArticleType type) {
        return GetArticleDto.wrap(
                type != null
                        ? this.articleService.getArticleByType(type)
                        : this.articleService.getAllArticles()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<GetArticleDto> getArticleById(@PathVariable long id) {
        return ResponseEntity.of(
                this.articleService.getArticleById(id).map(GetArticleDto::wrap)
        );
    }

    @GetMapping("/exercises/category")
    public List<GetArticleDto> getExercisesFromCategory(@RequestParam(required = false) Category category) {
        return GetArticleDto.wrap(
                category != null
                        ? this.articleService.getExercisesFromCategory(category)
                        : this.articleService.getArticleByType(ArticleType.EXERCISES)
        );
    }

    @GetMapping("/exercises/allCategories")
    public List<Category> getListOfCategories() {
        return articleService.getCategories();
    }

}
