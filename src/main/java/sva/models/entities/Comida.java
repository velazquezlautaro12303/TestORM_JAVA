package sva.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comida")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo")
public class Comida extends Persistente {

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "VARCHAR(50)")
    private String descripcion;

    @OneToMany(mappedBy = "comida", cascade = {CascadeType.ALL})
    private List<ComidaComposicion> composicion;

    @ManyToOne
    @JoinColumn(name = "diaComida_id", referencedColumnName = "id")
    private DiaComida diaComida;

    public Comida(String nombre, String descripcion, List<ComidaComposicion> composicion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.composicion = composicion;
    }
}
