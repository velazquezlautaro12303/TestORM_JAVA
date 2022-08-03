package domain.DBTest;

import org.junit.Assert;
import org.junit.Test;
import sva.models.entities.*;
import sva.db.EntityManagerHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EMTest {
    @Test
    public void persistir1PersonaTest(){
        Profesional profesional = new Profesional();
        Direccion direccion = new Direccion("Gaspar Campos", 1228);
        Especialidad nutricionista = new Especialidad("Nutricionista");
        Especialidad kinesiologo = new Especialidad("Kinesiologo");
        List<Especialidad> especialidades = new ArrayList<>();
        especialidades.add(nutricionista);
        especialidades.add(kinesiologo);

        profesional.setApellido("Herrera");
        profesional.setNombre("Facundo");
        profesional.setDireccion(direccion);
        profesional.setEspecialidad(especialidades);
        profesional.setMatricula("XT1234");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(profesional);
        EntityManagerHelper.commit();
    }

    @Test
    public void persistir1PacienteTest(){
        Profesional profesional = new Profesional();
        Direccion direccion = new Direccion("Gaspar Campos", 1228);
        Especialidad nutricionista = new Especialidad("Nutricionista");
        Especialidad kinesiologo = new Especialidad("Kinesiologo");
        List<Especialidad> especialidades = new ArrayList<>();
        especialidades.add(nutricionista);
        especialidades.add(kinesiologo);

        profesional.setApellido("Herrera");
        profesional.setNombre("Facundo");
        profesional.setDireccion(direccion);
        profesional.setEspecialidad(especialidades);
        profesional.setMatricula("XT1234");

        ObjetivoPlan objetivo = new ObjetivoPlan("Bajar de peso");
        List<ObjetivoPlan> objetivos = new ArrayList<>();
        objetivos.add(objetivo);

        List<Comida> comidas = new ArrayList<>();
        ComidaComposicion composicionPolloConPapas = new ComidaComposicion("Pollo proteico", TipoAlimento.PROTEINA, 70.0);
        List<ComidaComposicion> composiciones = new ArrayList<>();
        composiciones.add(composicionPolloConPapas);
        AlmuerzoCena pollo = new AlmuerzoCena("Pollo con papas", "Muslo de pollo con papas fritas al horno", composiciones);
        composicionPolloConPapas.setComida(pollo);
        comidas.add(pollo);
        DiaComida dia1 = new DiaComida(1, comidas);
        List<DiaComida> diasComida = new ArrayList<>();
        diasComida.add(dia1);

        Paciente paciente = new Paciente();
        Direccion direccion2 = new Direccion("Malnatti", 1713);
        PlanAlimenticio plan1 = new PlanAlimenticio("Plan Fitness", ModalidadPlan.SEMANAL, profesional, paciente, LocalDate.now(), LocalDate.now(), objetivos, diasComida, new ArrayList<DiaColacion>(), new ArrayList<DiaBebida>());
        List<PlanAlimenticio> planes = new ArrayList<>();
        planes.add(plan1);

        paciente.setNombre("Facundo");
        paciente.setApellido("Herrera");
        paciente.setDisciplina("Calistenia");
        paciente.setPeso(65.0);
        paciente.setFechaNacimiento(new Date());
        paciente.setMedidaCintura(70.0);
        paciente.setSexo(Sexo.MASCULINO);
        paciente.setDireccion(direccion2);
        paciente.setPlanes(planes);

        EntityManagerHelper.beginTransaction();
        /*EntityManagerHelper.getEntityManager().persist(objetivo);
        EntityManagerHelper.getEntityManager().persist(pollo);
        EntityManagerHelper.getEntityManager().persist(dia1);
        EntityManagerHelper.getEntityManager().persist(direccion);
        EntityManagerHelper.getEntityManager().persist(direccion2);
        EntityManagerHelper.getEntityManager().persist(plan1);
        EntityManagerHelper.getEntityManager().persist(composicionPolloConPapas);
        EntityManagerHelper.getEntityManager().persist(profesional);*/
        EntityManagerHelper.getEntityManager().persist(paciente);
        EntityManagerHelper.commit();
    }

    @Test
    public void recuperandoAFacu(){
        Profesional facu = (Profesional) EntityManagerHelper.createQuery("from Profesional where nombre = 'Facundo'").getSingleResult();
        Assert.assertEquals("Facundo", facu.getNombre());
    }
}
