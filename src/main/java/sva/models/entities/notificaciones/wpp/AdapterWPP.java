package sva.models.entities.notificaciones.wpp;

import sva.models.entities.Profesional;

public interface AdapterWPP {
    void notificar(String mensaje, Profesional destinatario);
}
