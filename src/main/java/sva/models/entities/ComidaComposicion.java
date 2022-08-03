package sva.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "comidaComposicion")
public class ComidaComposicion extends Persistente {

    @Column(name = "descripcion", columnDefinition = "VARCHAR(255)")
    private String descripcion;

    @Column(name = "tipoAlimento", columnDefinition = "VARCHAR(30)")
    private TipoAlimento tipo;

    @Column(name = "porcentaje", columnDefinition = "DOUBLE")
    private Double porcentaje;

    @ManyToOne
    @JoinColumn(name = "comida_id", referencedColumnName = "id")
    private Comida comida;

    public ComidaComposicion(String descripcion, TipoAlimento tipo, Double porcentaje) {
        this.setDescripcion(descripcion);
        this.setTipo(tipo);
        this.setPorcentaje(porcentaje);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoAlimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlimento tipo) {
        this.tipo = tipo;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }
}
