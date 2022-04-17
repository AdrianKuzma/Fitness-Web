package sk.fitness.fitnessweb.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.fitness.fitnessweb.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    private ArticleType type;

    private String image;

    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "favorites")
    private List<User> favoriteUsers;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<User> getFavoriteUsers() {
        return favoriteUsers;
    }

    public void setFavoriteUsers(List<User> favoriteUsers) {
        this.favoriteUsers = favoriteUsers;
    }
}
