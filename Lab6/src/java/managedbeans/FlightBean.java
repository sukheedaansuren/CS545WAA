/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Khandaa
 */
@ManagedBean("flightBean")
@SessionScoped
public class FlightBean {
    public String from;
    public String to;
    public String departureDate;
    public String returnDate;
    public String oneway;
    public static String[] seatClasses = {"first", "exact", "stopover"};
    public static Map<String, Object> seatClassesValue;

    static {
        seatClassesValue = new LinkedHashMap();
        seatClassesValue.put("first", "First class");
        seatClassesValue.put("exact", "Exact these dates");
        seatClassesValue.put("stopover", "No stopover");
    }

    public static String[] getSeatClasses() {
        return seatClasses;
    }

    public static void setSeatClasses(String[] seatClasses) {
        FlightBean.seatClasses = seatClasses;
    }

    public Map<String, Object> getSeatClassesValue() {
        return seatClassesValue;
    }

    public String getSeatClassesInString() {
        return Arrays.toString(seatClasses);
    }

    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        this.oneway = oneway;
    }

}
