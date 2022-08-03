package sva.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "bebida")
public class Bebida extends Persistente {

    @Column(name = "descripcion", columnDefinition = "VARCHAR(50)")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "diaBebida_id", referencedColumnName = "id")
    private DiaBebida diaBebida;
}
