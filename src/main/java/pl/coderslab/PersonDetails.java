package pl.coderslab;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons_details")
public class PersonDetails {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;
    private String sex;
    private String country;
    private String notes;
    private boolean mailingList;
    @ManyToMany
    private List<ProgrammingSkill> programmingSkills;
    @ManyToMany
    private List<Hobby> hobbies;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public List<ProgrammingSkill> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(List<ProgrammingSkill> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "person=" + person +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", notes='" + notes + '\'' +
                ", mailingList=" + mailingList +
                ", programmingSkills=" + programmingSkills +
                ", hobbies=" + hobbies +
                '}';
    }
}