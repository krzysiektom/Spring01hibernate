package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher entity){
        entityManager.persist(entity);
    }

    public void update(Publisher entity){
        entityManager.merge(entity);
    }

    public Publisher findById (Long id){
        return entityManager.find(Publisher.class,id);
    }
    public void delete(Publisher entity){
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }
}
