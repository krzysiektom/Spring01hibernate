package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByNip(String NIP);
    Publisher findByRegon(String REGON);
    Publisher findByName(String name);
}
