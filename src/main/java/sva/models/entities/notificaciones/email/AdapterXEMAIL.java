package sva.models.entities.notificaciones.email;


import sva.models.entities.Profesional;

public class AdapterXEMAIL implements AdapterEMAIL {

    public void notificar(String asunto, String mensaje, Profesional destinatario) {
        System.out.printf("Notifico por mail el siguiente mensaje: %s\n De asunto: %s", mensaje, asunto);
    }

}