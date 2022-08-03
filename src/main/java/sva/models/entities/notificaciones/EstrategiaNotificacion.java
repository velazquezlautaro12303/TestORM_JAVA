package sva.models.entities.notificaciones;

import sva.models.entities.Profesional;

public interface EstrategiaNotificacion {
    void notificar(String mensaje, Profesional destinatario);
}

