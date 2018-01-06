package com.corejsf;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.IntegerConverter;

@FacesComponent("com.corejsf.Spinner")
public class UISpinner extends UIInput {

    private static final String MORE = ".more";
    private static final String LESS = ".less";

    public UISpinner() {
        setConverter(new IntegerConverter()); // to convert the submitted value
        setRendererType(null); // this component renders itself
    }

    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = getClientId(context);
        encodeInputField(writer, clientId);
        encodeDecrementButton(writer, clientId);
        encodeIncrementButton(writer, clientId);
    }

    public void decode(FacesContext context) {
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String clientId = getClientId(context);
        int increment;
        if (requestMap.containsKey(clientId + MORE)) {
            increment = 1;
        } else if (requestMap.containsKey(clientId + LESS)) {
            increment = -1;
        } else {
            increment = 0;
        }
        try {
            int submittedValue
                    = Integer.parseInt((String) requestMap.get(clientId));
            int newValue = getIncrementedValue(submittedValue, increment);
            setSubmittedValue("" + newValue);
        } catch (NumberFormatException ex) {
// let the converter take care of bad input, but we still have
// to set the submitted value or the converter won't have
// any input to deal with
            setSubmittedValue((String) requestMap.get(clientId));
        }
    }

    private void encodeInputField(ResponseWriter writer, String clientId)
            throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("name", clientId, null);

        Object v = getValue();
        if (v != null) {
            writer.writeAttribute("value", v, "value");
        }

        Object size = getAttributes().get("size");
        if (size != null) {
            writer.writeAttribute("size", size, "size");
        }

        writer.endElement("input");
    }

    private void encodeDecrementButton(ResponseWriter writer, String clientId)
            throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + LESS, null);
        writer.writeAttribute("value", "<", "value");
        writer.endElement("input");
    }

    private void encodeIncrementButton(ResponseWriter writer, String clientId)
            throws IOException {
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + MORE, null);
        writer.writeAttribute("value", ">", "value");
        writer.endElement("input");

    }

    private int getIncrementedValue(int submittedValue, int increment) {
        Integer minimum = toInteger(getAttributes().get("minimum"));
        Integer maximum = toInteger(getAttributes().get("maximum"));
        int newValue = submittedValue + increment;

        if (maximum != null && submittedValue > maximum)
            return maximum;
        if (minimum != null && submittedValue < minimum)
            return minimum;
        
        if ((minimum == null || newValue >= minimum.intValue())
                && (maximum == null || newValue <= maximum.intValue())) {
            return newValue;
        } else {
            return submittedValue;
        }
    }

    private static Integer toInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        throw new IllegalArgumentException("Cannot convert " + value);
    }
}
