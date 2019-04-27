package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getByEmail(String email);
    Author getByPesel(String pesel);
    List<Author> getByLastName(String lastName);
    Author getByFirstNameAndLastName(String firstName, String lasrtName);
}
