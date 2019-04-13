package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public Person get(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> getAll() {
        Query query = entityManager.createQuery("select p from Person p");
        List<Person> persons = query.getResultList();
        return persons;
    }

    public void save(Person entity) {
        entityManager.persist(entity);
    }

    public void update(Person entity) {
        entityManager.merge(entity);
    }

    public void delete(Person entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

}
