
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Khandaa
 */
@ManagedBean(name = "empBean")
@SessionScoped
public class EmployeeBean implements Serializable {
    private Employee employee;
    
    private static final Employee[] employees = new Employee[]{
        new Employee(1432, "Frank Brown", "625-345-2635", 45089.5),
        new Employee(1321, "John Doe", "625-345-3321", 56003.0),
        new Employee(1634, "Mary Jones", "625-345-3421", 73998.3),};

    public Employee[] getEmployees() {
        return employees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public String show(){
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(params.get("empId"));
        for(Employee e : this.employees) {
            if(e.id == id) {
                this.setEmployee(e);
                break;
            }
        }
        return "show";
    }
    
    // Employee class
    public static class Employee {
        private int id;
        private String name;
        private String phone;
        private double salary;

        public Employee(int id, String name, String phone, double salary) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

    }

}
