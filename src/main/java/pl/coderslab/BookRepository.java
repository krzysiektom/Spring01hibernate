package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByAuthors(Author author);
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByRatingGreaterThan(BigDecimal rating);
    Book findFirstByCategoryOrderByTitleAsc(Category category);
}
