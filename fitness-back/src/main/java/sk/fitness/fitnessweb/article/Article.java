package sk.fitness.fitnessweb.article;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import sk.fitness.fitnessweb.favourite.Favourite;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "article_favourite",joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "favourite_id"))
    @JsonManagedReference
    private List<Favourite> favourites;

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

    public List<Favourite> getFavourites() {
        return favourites;
    }

    public void setFavourites(Favourite favourite) {
        this.favourites.add(favourite);
    }
}
