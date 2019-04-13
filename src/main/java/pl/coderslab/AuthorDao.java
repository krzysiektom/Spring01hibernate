package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Author entity) {
        entityManager.persist(entity);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public Author get(Long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> getAll() {
        Query query = entityManager.createQuery("select p from Author p");
        List<Author> allAuthors = query.getResultList();
        return allAuthors;
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

}
