package sva.models.entities;

public class SexoParser {
    public static String sexoToString(Enum<Sexo> sexo){
        if (Sexo.FEMENINO.equals(sexo)) {
            return "FEMENINO";
        }
        return "MASCULINO";
    }
    public static Sexo stringToSexo(String string){
        switch (string){
            case "MASCULINO": return Sexo.MASCULINO;
            default: return Sexo.FEMENINO;
        }
    }
}
