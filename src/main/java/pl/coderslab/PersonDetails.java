package pl.coderslab;

import javax.persistence.*;

@Entity
@Table(name = "persons_details")
public class PersonDetails {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_id", unique=true)
    private Person person;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;

    public PersonDetails() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}