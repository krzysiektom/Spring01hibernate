package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Book entity) {
        entityManager.persist(entity);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Book> returnAllBooks() {
        Query query = entityManager.createQuery("select p from Book p");
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("select p from Book p WHERE rating>:rating");
        query.setParameter("rating",rating);
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }
}