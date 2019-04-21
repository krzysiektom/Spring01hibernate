package pl.coderslab;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@StartWith("A")
    @Size(groups = ValidationBook.class, min = 5)
    @NotEmpty(groups = {ValidationBook.class, ValidationProposition.class})
    @Column(name = "myTitle",
            length = 100)
    private String title;

    @NotNull(groups = ValidationBook.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @DecimalMin(groups = ValidationBook.class, value = "1")
    @DecimalMax(groups = ValidationBook.class, value = "10")
    @Column(scale = 2, precision = 4)
    private BigDecimal rating;

    @NotNull(groups = ValidationBook.class)
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @Size(groups = ValidationBook.class, max = 600)
    @Column(columnDefinition = "TEXT")
    @NotEmpty(groups = ValidationProposition.class)
    private String description;

    @NotNull(groups = ValidationBook.class)
    @Min(groups = ValidationBook.class, value = 1)
    private Integer pages;

    private boolean proposition;

    public Book() {
    }

    public Book(String title, BigDecimal rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", rating=" + rating +
                ", publisher=" + publisher +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", proposition=" + proposition +
                '}';
    }
}