package pl.coderslab;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NIP
    private String nip;

    @REGON
    private String regon;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIP() {
        return nip;
    }

    public void setNIP(String NIP) {
        this.nip = NIP;
    }

    public String getREGON() {
        return regon;
    }

    public void setREGON(String REGON) {
        this.regon = REGON;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", NIP='" + nip + '\'' +
                ", REGON='" + regon + '\'' +
                '}';
    }
}
