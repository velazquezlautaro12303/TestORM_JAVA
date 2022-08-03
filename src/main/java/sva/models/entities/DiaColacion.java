package sva.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diaColacion")
public class DiaColacion extends Persistente {

    @Column(name = "nroDia", columnDefinition = "INTEGER(3)")
    private Integer nroDia;

    @OneToMany(mappedBy = "diaComida", cascade = {CascadeType.ALL})
    private List<Comida> comidas;

    @Column(name = "momento", columnDefinition = "VARCHAR(30)")
    private MomentoColacion momento;

    @ManyToOne
    @JoinColumn(name = "planAlimenticio_id", referencedColumnName = "id")
    private PlanAlimenticio planAlimenticio;
}
