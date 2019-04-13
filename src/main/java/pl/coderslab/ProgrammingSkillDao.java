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
public class ProgrammingSkillDao {
    @PersistenceContext
    EntityManager entityManager;

    public ProgrammingSkill get(Long id) {
        return entityManager.find(ProgrammingSkill.class, id);
    }

    public List<ProgrammingSkill> getAll() {
        Query query = entityManager.createQuery("select p from ProgrammingSkill p");
        List<ProgrammingSkill> programmingSkills = query.getResultList();
        return programmingSkills;
    }

    public void save(ProgrammingSkill entity) {
        entityManager.persist(entity);
    }

    public void update(ProgrammingSkill entity) {
        entityManager.merge(entity);
    }

    public void delete(ProgrammingSkill entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

}
