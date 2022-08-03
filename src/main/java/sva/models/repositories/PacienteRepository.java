package sva.models.repositories;

import sva.models.entities.Paciente;

public class PacienteRepository extends RepositorioGenerico<Paciente>{

    public PacienteRepository() {
        super(Paciente.class);
    }
}
