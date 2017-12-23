package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converters.TConverter")
public class TConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String s = value.toString();
        String i = s.substring(0, 1);
        i = "F".equals(i) ? "Fahrenheit" : "Celcius";
        return String.format("%s %s", s.substring(1, s.length()), i);
    }
    
}
