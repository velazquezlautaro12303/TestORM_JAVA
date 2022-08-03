package sva.models.entities;

import sva.converters.EstrategiaNotificacionConverter;
import sva.models.entities.notificaciones.EstrategiaNotificacion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Profesional")
public class Profesional extends Persistente{

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(name = "apellido", columnDefinition = "VARCHAR(50)")
    private String apellido;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Especialidad> especialidad;

    @Column(name = "matricula", columnDefinition = "VARCHAR(50)")
    private String matricula;

    @Convert(converter = EstrategiaNotificacionConverter.class)
    private EstrategiaNotificacion formaDeNotificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public EstrategiaNotificacion getFormaDeNotificacion() {
        return formaDeNotificacion;
    }

    public void setFormaDeNotificacion(EstrategiaNotificacion formaDeNotificacion) {
        this.formaDeNotificacion = formaDeNotificacion;
    }

    public List<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }
}
