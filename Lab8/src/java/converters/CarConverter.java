package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converters.CarConverter")
public class CarConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String s = value.toString();
        return s;
    }
    
}
