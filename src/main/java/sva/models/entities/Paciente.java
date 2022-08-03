package sva.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente extends Persistente{

    @Column(name = "nombre", columnDefinition = "VARCHAR(255)")
    private String nombre;

    @Column(name = "apellido", columnDefinition = "VARCHAR(255)")
    private String apellido;

    @Column(name = "fechaNacimiento", columnDefinition = "DATE")
    private Date fechaNacimiento;

    @Column(name = "sexo")
    @Enumerated(value = EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @Column(name = "disciplina", columnDefinition = "VARCHAR(255)")
    private String disciplina;

    @Column(name = "medidaCintura", columnDefinition = "DOUBLE")
    private Double medidaCintura;

    @Column(name = "peso", columnDefinition = "DOUBLE")
    private Double peso;

    @OneToMany(mappedBy = "paciente", cascade = {CascadeType.ALL})
    private List<PlanAlimenticio> planes;

    public Integer getEdad() {
        return Period.between(this.convertToLocalDate(this.fechaNacimiento), LocalDate.now()).getYears();
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(Double medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public List<PlanAlimenticio> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlanAlimenticio> planes) {
        this.planes = planes;
    }
}
