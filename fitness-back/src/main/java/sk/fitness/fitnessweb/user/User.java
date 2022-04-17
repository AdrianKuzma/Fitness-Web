package sk.fitness.fitnessweb.user;

import sk.fitness.fitnessweb.article.Article;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "favorite",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "article_id") }
    )
    private List<Article> favorites;

    public User() {
    }

    public User(String username, String password, String email, List<Article> favorites) {
        this.username = username;
        this.password = password;
        this.favorites = favorites;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Article> favorites) {
        this.favorites = favorites;
    }
}
