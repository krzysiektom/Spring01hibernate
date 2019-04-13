package pl.coderslab;

import javax.persistence.*;

@Entity
@Table(name = "hobbies")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Hobby() {
    }

    public String getHobby() {
        return name;
    }

    public void setHobby(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
