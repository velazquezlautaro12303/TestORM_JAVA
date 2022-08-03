package sva.models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@DiscriminatorValue("desayunoMerienda")
public class DesayunoMerienda extends Comida {
    public DesayunoMerienda(String nombre, String descripcion, List<ComidaComposicion> composicion) {
        super(nombre, descripcion, composicion);
    }
}
