package pl.coderslab;

import javax.persistence.*;

@Entity
@Table(name = "programmingSkills")
public class ProgrammingSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skill;

    public ProgrammingSkill() {
    }

    public ProgrammingSkill(String skill) {
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return skill;
    }
}
