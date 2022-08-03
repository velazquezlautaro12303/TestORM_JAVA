package sva.models.entities.notificaciones.wpp;

import sva.models.entities.Profesional;

public class AdapterXWPP implements AdapterWPP {
    public static final String ACCOUNT_SID = "ACc094cd580197f8cb3bbe6287ed0d350d";
    public static final String AUTH_TOKEN = "82b38d16f36330c9c187ccc7d6bc56ac";

    public void notificar(String mensaje, Profesional destinatario){
        System.out.println("Notifico por wpp");
    }
}