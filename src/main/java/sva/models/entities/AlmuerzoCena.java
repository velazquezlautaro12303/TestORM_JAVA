package sva.models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("almuerzoCena")
public class AlmuerzoCena extends Comida {
    public AlmuerzoCena(String nombre, String descripcion, List<ComidaComposicion> composicion) {
        super(nombre, descripcion, composicion);
    }
}
