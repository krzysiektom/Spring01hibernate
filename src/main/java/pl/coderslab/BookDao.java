package pl.coderslab;

import org.hibernate.Hibernate;
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

    public Book get(long id) {
        Book book = entityManager.find(Book.class, id);
        if (null != book) {
            Hibernate.initialize(book.getAuthors());
            Hibernate.initialize(book.getPublisher());
        }
        return book;
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("select p from Book p where not proposition= true");
        return query.getResultList();
    }

}