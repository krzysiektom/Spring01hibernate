package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByAuthors(Author author);
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByRatingGreaterThan(BigDecimal rating);
    Book findFirstByCategoryOrderByTitleAsc(Category category);

    @Query("SELECT b FROM Book b WHERE b.title=?1")
    List<Book> findByTitleQuery (String title);

    @Query("SELECT b FROM Book b WHERE b.category=?1")
    List<Book> findByCategoryQuery(Category category);


}
