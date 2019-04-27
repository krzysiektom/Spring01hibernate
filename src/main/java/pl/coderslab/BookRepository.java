package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepoCustom {
    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByAuthors(Author author);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRatingGreaterThan(BigDecimal rating);

    Book findFirstByCategoryOrderByTitleAsc(Category category);

    @Query("SELECT b FROM Book b WHERE b.title=?1")
    List<Book> findByTitleQuery(String title);

    @Query("SELECT b FROM Book b WHERE b.category=?1")
    List<Book> findByCategoryQuery(Category category);

    @Query("SELECT b FROM Book b where b.category BETWEEN ?1 AND ?2")
    List<Book> findByRatingBetweenQuery(BigDecimal rat1, BigDecimal rat2);

    @Query("SELECT b FROM Book b where b.publisher=?1")
    List<Book> findByPublisherQuery(Publisher publisher);

    @Query(value = "SELECT * FROM books WHERE category_id=?1 order by myTitle LIMIT 1", nativeQuery = true)
    Book findByCategoryOrderByTitleQuery(Long category);

}
