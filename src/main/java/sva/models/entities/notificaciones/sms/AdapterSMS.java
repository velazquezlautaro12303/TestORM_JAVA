package sva.models.entities.notificaciones.sms;

import sva.models.entities.Profesional;

public interface AdapterSMS {
    void notificar(String mensaje, Profesional destinatario);
}
