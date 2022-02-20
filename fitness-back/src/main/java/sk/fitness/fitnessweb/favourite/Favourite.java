package sk.fitness.fitnessweb.favourite;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import sk.fitness.fitnessweb.article.Article;
import sk.fitness.fitnessweb.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany
    private List<Article> articles;

    public Favourite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(Article article) {
        this.articles.add(article);
    }
}
