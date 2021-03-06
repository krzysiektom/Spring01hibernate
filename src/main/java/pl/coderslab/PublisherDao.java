package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher entity) {
        entityManager.persist(entity);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public Publisher get(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Publisher> getAll() {
        Query query = entityManager.createQuery("select p from Publisher p");
        List<Publisher> allPublishers = query.getResultList();
        return allPublishers;
    }
}
