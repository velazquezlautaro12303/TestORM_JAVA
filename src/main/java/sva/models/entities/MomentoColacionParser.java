package sva.models.entities;

public class MomentoColacionParser {
    public static String momentoToString(Enum<MomentoColacion> momento){
        if (MomentoColacion.ALMUERZO_MERIENDA.equals(momento)) return "ALMUERZO_MERIENDA";
        else if(MomentoColacion.DESAYUNO_ALMUERZO.equals(momento)) return "DESAYUNO_ALMUERZO";
        else return "MERIENDA_CENA";
    }
    public static MomentoColacion stringToMomento(String string){
        switch (string){
            case "ALMUERZO_MERIENDA": return MomentoColacion.ALMUERZO_MERIENDA;
            case "DESAYUNO_ALMUERZO": return MomentoColacion.DESAYUNO_ALMUERZO;
            default: return MomentoColacion.MERIENDA_CENA;
        }
    }
}
