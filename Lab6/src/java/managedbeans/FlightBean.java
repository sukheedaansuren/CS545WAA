/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "flightBean")
@SessionScoped
public class FlightBean {

    public String from;
    public String to;
    public String departureDate;
    public String returnDate;
    public String oneway;
    public String[] seat;

    public String getSeatInString() {
        return Arrays.toString(seat);
    }
    
    
    public String[] getSeat() {
        return seat;
    }
    
    public void setSeat(String[] seat) {
        this.seat = seat;
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
