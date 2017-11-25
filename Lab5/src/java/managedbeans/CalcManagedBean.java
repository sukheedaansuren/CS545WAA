package managedbeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Khandaa
 */
@Named(value = "calcManagedBean")
@RequestScoped
public class CalcManagedBean {

    private double first;
    private double second;
    private double result;

    public String add() {
        result = first + second;
        return null;
    }

    public String  sub() {
        result = first - second;
        return null;
    }

    public String  mul() {
        result = first * second;
        return null;
    }

    public String  divide() {
        result = first / second;
        return null;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
    
    
}
