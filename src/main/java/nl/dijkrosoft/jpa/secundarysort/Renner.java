package nl.dijkrosoft.jpa.secundarysort;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Renner {

    public Renner() {
    }

    @Id
    int id;

    int rugnummer;

    String name;

    String team;
}
