package pl.coderslab;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public PersonDetails get(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public List<PersonDetails> getAll() {
        Query query = entityManager.createQuery("select p from PersonDetails p");
        List<PersonDetails> personDetails = query.getResultList();
        return personDetails;
    }

    public void save(PersonDetails entity) {
        entityManager.persist(entity);
    }

    public void update(PersonDetails entity) {
        entityManager.merge(entity);
    }

    public void delete(PersonDetails entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

}
