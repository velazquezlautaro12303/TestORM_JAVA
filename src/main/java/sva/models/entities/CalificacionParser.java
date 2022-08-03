package sva.models.entities;

public class CalificacionParser {
    public static String calificacionToString(Enum<Calificacion> calificacion){
        if (Calificacion.EXCELENTE.equals(calificacion)) return "EXCELENTE";
        else if(Calificacion.BUENA.equals(calificacion)) return "BUENA";
        else return "REGULAR";
    }
    public static Calificacion stringToCalificacion(String string){
        switch (string){
            case "EXCELENTE": return Calificacion.EXCELENTE;
            case "BUENA": return Calificacion.BUENA;
            default: return Calificacion.REGULAR;
        }
    }
}
