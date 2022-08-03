package sva.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion extends Persistente {

    @Column(name = "calle", columnDefinition = "VARCHAR(255)")
    private String calle;

    @Column(name = "numero", columnDefinition = "INTEGER(10)")
    private Integer numero;

    public Direccion() {}

    public Direccion(String calle, Integer numero) {
        this.calle = calle;
        this.numero = numero;
    }
}
