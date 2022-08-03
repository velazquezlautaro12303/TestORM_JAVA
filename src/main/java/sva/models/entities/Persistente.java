package sva.models.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persistente {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    public Integer getId() {
        return id;
    }
}
