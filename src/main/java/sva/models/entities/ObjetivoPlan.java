package sva.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "objetivoPlan")
public class ObjetivoPlan extends Persistente {

    @Column(name = "descripcion", columnDefinition = "VARCHAR(50)")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "planAlimenticio_id", referencedColumnName = "id")
    private PlanAlimenticio planAlimenticio;

    public ObjetivoPlan(String descripcion) {
        this.descripcion = descripcion;
    }
}
