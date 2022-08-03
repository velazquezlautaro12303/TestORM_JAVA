package sva.models.entities.notificaciones.email;

import sva.models.entities.Profesional;

public interface AdapterEMAIL {
    void notificar(String asunto, String mensaje, Profesional destinatario);
}
