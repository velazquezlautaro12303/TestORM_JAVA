package sva.models.entities.notificaciones.email;

import sva.models.entities.Profesional;
import sva.models.entities.notificaciones.EstrategiaNotificacion;

public class NotificarEMAIL implements EstrategiaNotificacion {
    AdapterXEMAIL adapter   = new AdapterXEMAIL();
    String nombre           = new String("EMAIL");

    public String getNombre() {
        return nombre;
    }
    public void notificar(String mensaje, Profesional destinatario){
        adapter.notificar("Notificacion Scooby", mensaje, destinatario);
    }
}
