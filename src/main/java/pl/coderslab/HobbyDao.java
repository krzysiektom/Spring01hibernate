package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HobbyDao {
    @PersistenceContext
    EntityManager entityManager;

    public Hobby get(Long id) {
        return entityManager.find(Hobby.class, id);
    }

    public List<Hobby> getAll() {
        Query query = entityManager.createQuery("select p from Hobby p");
        List<Hobby> hobbies = query.getResultList();
        return hobbies;
    }

    public void save(Hobby entity) {
        entityManager.persist(entity);
    }

    public void update(Hobby entity) {
        entityManager.merge(entity);
    }

    public void delete(Hobby entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }
    public Hobby getByName(String name){
        Query query = entityManager.createQuery("select p from Hobby p where name=:name");
        query.setParameter("name",name);
        return (Hobby) query.getSingleResult();
    }
}
