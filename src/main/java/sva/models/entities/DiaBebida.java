package sva.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diaBebida")
public class DiaBebida extends Persistente {

    @Column(name = "nroDia", columnDefinition = "INTEGER(3)")
    private Integer nroDia;

    @OneToMany(mappedBy = "diaBebida", cascade = {CascadeType.ALL})
    private List<Bebida> bebidas;

    @ManyToOne
    @JoinColumn(name = "planAlimenticio_id", referencedColumnName = "id")
    private PlanAlimenticio planAlimenticio;
}
