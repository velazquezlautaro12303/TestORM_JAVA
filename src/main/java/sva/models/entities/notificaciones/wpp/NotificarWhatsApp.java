package sva.models.entities.notificaciones.wpp;
import sva.models.entities.Profesional;
import sva.models.entities.notificaciones.EstrategiaNotificacion;

public class NotificarWhatsApp implements EstrategiaNotificacion {
    AdapterXWPP adapter = new AdapterXWPP();
    String nombre           = new String("WPP");

    public String getNombre() {
        return nombre;
    }

    public void notificar(String mensaje, Profesional destinatario){
        adapter.notificar(mensaje, destinatario);
    }

}
