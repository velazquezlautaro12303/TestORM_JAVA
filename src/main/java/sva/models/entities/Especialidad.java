package sva.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad extends Persistente{
    private String descripcion;

    public Especialidad(String descripcion) {
        this.setDescripcion(descripcion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
