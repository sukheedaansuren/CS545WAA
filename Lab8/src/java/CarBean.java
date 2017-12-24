import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@ManagedBean(name = "carBean")
@SessionScoped
public class CarBean implements Serializable {

    private String brand; // Mercedes | BMW
    private String license; // 2 capitals, followed by a dash ‘-’, followed by 2 numbers, followed by a dash ‘-’, followed by 2 capitals.
    
    @Min(1) @Max(10000)
    private int price; // 1 and 100000

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    

}
