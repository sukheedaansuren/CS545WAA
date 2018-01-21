import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cdshop") //@Named="bean"
@SessionScoped
public class CDShop {
 
    private Product[] products = {
        new Product("A23445", "Oh New York", 790.80),
        new Product("A2343", "La la land", 7900.80),
        new Product("B234", "Radio GAGA", 1235.40),
        new Product("B235235", "The winner takes it all", 467.10),
        new Product("C23235", "Game of Thrones", 89.30),
        new Product("C242", "Yellow submarine", 3423.45),
        new Product("D24234", "The Beatles", 21355.93),
        new Product("D2423", "Coldplay", 55.25),
        new Product("E234", "Queen - Don't stop me now", 534.03),
        new Product("E797", "Pinkfloyd - Wish you were here", 4565.20),
        new Product("F1555", "Rihanna - Umbrella", 490876.00),
        new Product("F0328", "Sia - Chandelier", 949.00),
    };

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    
    
    
}
