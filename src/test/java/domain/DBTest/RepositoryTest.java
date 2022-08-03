package domain.DBTest;

import org.junit.Assert;
import org.junit.Test;
import sva.db.EntityManagerHelper;
import sva.models.entities.*;
import sva.models.entities.notificaciones.wpp.NotificarWhatsApp;
import sva.models.repositories.PacienteRepository;
import sva.models.repositories.ProfesionalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RepositoryTest {
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

        ProfesionalRepository pr = new ProfesionalRepository();
        pr.agregar(profesional);
    }

    @Test
    public void persistir1PersonaConEstrategiaTest(){
        Profesional profesional = new Profesional();
        Direccion direccion = new Direccion("Medrano", 540);
        NotificarWhatsApp notiWpp = new NotificarWhatsApp();
        Especialidad nutricionista = new Especialidad("Nutricionista");
        Especialidad kinesiologo = new Especialidad("Kinesiologo");
        List<Especialidad> especialidades = new ArrayList<>();
        especialidades.add(nutricionista);
        especialidades.add(kinesiologo);

        profesional.setApellido("Escobar");
        profesional.setNombre("Ezequiel");
        profesional.setDireccion(direccion);
        profesional.setEspecialidad(especialidades);
        profesional.setMatricula("XT4321");
        profesional.setFormaDeNotificacion(notiWpp);

        ProfesionalRepository pr = new ProfesionalRepository();
        pr.agregar(profesional);
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

        PacienteRepository pr = new PacienteRepository();
        pr.agregar(paciente);
    }

    @Test
    public void recuperandoAFacu(){
        ProfesionalRepository pr = new ProfesionalRepository();
        Optional<Profesional> optFacu = pr.buscar(1);
        Profesional facu = new Profesional();
        if(optFacu.isPresent()) facu = optFacu.get();
        Assert.assertEquals("Ezequiel", facu.getNombre());
    }
}
