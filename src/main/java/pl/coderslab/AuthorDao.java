package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author entity){
        entityManager.persist(entity);
    }

    public void update(Author entity){
        entityManager.merge(entity);
    }

    public Author findById (Long id){
        return entityManager.find(Author.class,id);
    }
    public void delete(Author entity){
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

}
