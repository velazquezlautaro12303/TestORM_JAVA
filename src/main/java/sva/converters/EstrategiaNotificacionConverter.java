package sva.converters;

import sva.models.entities.notificaciones.EstrategiaNotificacion;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EstrategiaNotificacionConverter implements AttributeConverter<EstrategiaNotificacion, String> {
    @Override
    public String convertToDatabaseColumn(EstrategiaNotificacion estrategiaNotificacion) {
        return estrategiaNotificacion.getClass().getName();
    }

    @Override
    public EstrategiaNotificacion convertToEntityAttribute(String s) {
        EstrategiaNotificacion estrategia = null;
        try {
            Class<?> c = Class.forName(s);
            estrategia = (EstrategiaNotificacion) c.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return estrategia;
    }
}