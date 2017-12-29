/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Khandaa
 */
@ManagedBean(name="abean") //@Named="bean"
@SessionScoped
public class Bean {
    private String airline;
    private Airline[] airlines = {
        new Airline("all", "All"),
        new Airline("ua", "United Airlines"),
        new Airline("nw", "NorthWest"),
        new Airline("klm", "KLM"),
        new Airline("koa", "Korean airline"),
        new Airline("miat", "MIAT")
    };
    private Flight[] flights = {
        new Flight("Amsterdam", "New York", "12/11/17", getAirlineSelected("ua"), 790.80),
        new Flight("Amsterdam", "New York", "12/14/17", getAirlineSelected("ua"), 790.80),
        new Flight("San Francisco", "New York", "12/11/17", getAirlineSelected("nw"), 1235.40),
        new Flight("San Francisco", "New York", "12/14/17", getAirlineSelected("nw"), 467.10),
        new Flight("Seoul", "New York", "12/13/17", getAirlineSelected("koa"), 89.30),
        new Flight("Seoul", "New York", "12/17/17", getAirlineSelected("koa"), 3423.45),
        new Flight("Ulaanbaatar", "New York", "11/11/17", getAirlineSelected("miat"), 2355.00),
        new Flight("Ulaanbaatar", "New York", "11/13/17", getAirlineSelected("miat"), 2355.00),
        new Flight("London", "New York", "11/31/17", getAirlineSelected("klm"), 2355.00),
        new Flight("London", "New York", "11/1/17", getAirlineSelected("klm"), 2355.00),
        new Flight("Mexico", "New York", "15/17/17", getAirlineSelected("ua"), 2355.00),
        new Flight("Mexico", "Chicago", "15/16/17", getAirlineSelected("ua"), 2355.00),
    };
    private Flight[] flightsSelected;
    
    public void onChangeAirline(ValueChangeEvent e) {
        int i = 0;
        for(Flight f : flights) {
            if(f.getAirline().getId().equals(e.getNewValue())) i++;
        }
        
        this.flightsSelected = new Flight[i];
        i = 0;
        for(Flight f : flights) {
            if(f.getAirline().getId().equals(e.getNewValue())) {
                this.flightsSelected[i++] = f;
            }
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

    public Airline getAirlineSelected(String key) {
        for(Airline a : airlines){
            if(a.getId().equals(key)) return a;
        }
        return new Airline(key, key);
    }
    
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
    
    public Flight[] getFlightsSelected() {
        return flightsSelected;
    }

    public void setFlightsSelected(Flight[] flightsSelected) {
        this.flightsSelected = flightsSelected;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline[] airlines) {
        this.airlines = airlines;
    }
    
}
