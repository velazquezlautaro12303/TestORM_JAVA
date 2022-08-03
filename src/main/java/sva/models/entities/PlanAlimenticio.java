package sva.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "planAlimenticio")
public class PlanAlimenticio extends Persistente {

    @Column(name = "nombre", columnDefinition = "VARCHAR(255)")
    private String nombre;

    @Column(name = "modalidad")
    @Enumerated(value = EnumType.STRING)
    private ModalidadPlan modalidad;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "profesional_id", referencedColumnName = "id")
    private Profesional profesional;

    @Column(name = "cantidadComidas", columnDefinition = "INTEGER(3)")
    private Integer cantidadComidas;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @Column(name = "fechaInicio", columnDefinition = "DATE")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin", columnDefinition = "DATE")
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "planAlimenticio", cascade = {CascadeType.ALL})
    private List<ObjetivoPlan> objetivosALograr;

    @Column(name = "notas", columnDefinition = "VARCHAR(255)")
    private String notas;

    @Column(name = "calificacion")
    @Enumerated(value = EnumType.STRING)
    private Calificacion calificacion;

    @OneToMany(mappedBy = "planAlimenticio", cascade = {CascadeType.ALL})
    private List<DiaComida> comidas;

    @OneToMany(mappedBy = "planAlimenticio", cascade = {CascadeType.ALL})
    private List<DiaColacion> colaciones;

    @OneToMany(mappedBy = "planAlimenticio", cascade = {CascadeType.ALL})
    private List<DiaBebida> bebidas;

    public PlanAlimenticio(
            String nombre,
            ModalidadPlan modalidad,
            Profesional profesionalAsignado,
            Paciente paciente,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            List<ObjetivoPlan> objetivosALograr,
            List<DiaComida> comidas,
            List<DiaColacion> colaciones,
            List<DiaBebida> bebidas) {
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.profesional = profesionalAsignado;
        this.paciente = paciente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.objetivosALograr = objetivosALograr;
        this.comidas = comidas;
        this.colaciones = colaciones;
        this.bebidas = bebidas;

        if(this.modalidad.equals(ModalidadPlan.SEMANAL)) this.setCantidadComidas(28);
        else if(this.modalidad.equals(ModalidadPlan.QUINCENAL)) this.setCantidadComidas(60);
        else this.setCantidadComidas(120);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ModalidadPlan getModalidad() {
        return modalidad;
    }

    public void setModalidad(ModalidadPlan modalidad) {
        this.modalidad = modalidad;
    }

    public Profesional getProfesionalAsignado() {
        return profesional;
    }

    public void setProfesionalAsignado(Profesional profesionalAsignado) {
        this.profesional = profesionalAsignado;
    }

    public Integer getCantidadComidas() {
        return cantidadComidas;
    }

    public void setCantidadComidas(Integer cantidadComidas) {
        this.cantidadComidas = cantidadComidas;
    }
}
