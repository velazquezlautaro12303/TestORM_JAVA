package sva.models.repositories;

import sva.models.entities.Comida;

public class ComidaRepository extends RepositorioGenerico<Comida>{
    public ComidaRepository(){
        super(Comida.class);
    }
}
