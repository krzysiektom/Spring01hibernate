package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getByEmail(String email);

    Author getByPesel(String pesel);

    List<Author> getByLastName(String lastName);

    Author getByFirstNameAndLastName(String firstName, String lasrtName);

    @Query("SELECT a FROM Author a WHERE a.email like ?1%")
    List<Author> getByEmailLikeQuery(String email);

    @Query("SELECT  a FROM Author a WHERE a.PESEL like ?1%")
    List<Author> getByPeselLikeQuery(String PESEL);
}
