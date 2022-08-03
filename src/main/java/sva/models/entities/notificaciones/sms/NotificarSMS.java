package sva.models.entities.notificaciones.sms;

import sva.models.entities.Profesional;
import sva.models.entities.notificaciones.EstrategiaNotificacion;

public class NotificarSMS implements EstrategiaNotificacion {
    AdapterXSMS adapter     = new AdapterXSMS();
    String nombre           = new String("SMS");

    public String getNombre() {
        return nombre;
    }
    public void notificar(String mensaje, Profesional destinatario){
        adapter.notificar(mensaje, destinatario);
    }
}
