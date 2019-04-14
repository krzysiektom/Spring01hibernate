package pl.coderslab;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String fullName;
    @PESEL
    private String PESEL;

    @Email
    private String email;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.fullName = this.firstName+" "+this.lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.fullName = this.firstName+" "+this.lastName;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
