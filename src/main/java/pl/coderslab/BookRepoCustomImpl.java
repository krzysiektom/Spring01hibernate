package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookRepoCustomImpl implements BookRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(int rating) {
        Query query = entityManager.createQuery("UPDATE Book b SET b.rating=:rating");
        query.setParameter("rating", rating);
        query.executeUpdate();
    }
}
