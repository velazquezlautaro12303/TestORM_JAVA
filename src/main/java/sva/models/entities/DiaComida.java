package sva.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diaComida")
public class DiaComida extends Persistente {

    @Column(name = "nroDia", columnDefinition = "INTEGER(3)")
    private Integer nroDia;

    @OneToMany(mappedBy = "diaComida", cascade = {CascadeType.ALL})
    private List<Comida> comidas;

    @ManyToOne
    @JoinColumn(name = "planAlimenticio_id", referencedColumnName = "id")
    private PlanAlimenticio planAlimenticio;

    public DiaComida(Integer nroDia, List<Comida> comidas) {
        this.nroDia = nroDia;
        this.comidas = comidas;
    }
}
