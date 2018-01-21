import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cart") //@Named="bean"
@SessionScoped
public class Cart {
    private String tmpProductCode;
    private String tmpProductName;
    private String tmpProductPrice;
    private Double totalPrice = 0d;
    
    private Map<String, Product> productMap = new HashMap();
    
    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    public Double getTotalPrice() {
        this.productMap.values().forEach((p) -> {
            this.totalPrice += p.getPrice() * p.getQuantity();
        }); 
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String add() {
        Product productNew;
        if(this.productMap.containsKey(this.tmpProductCode)) {
            productNew = this.productMap.get(this.tmpProductCode);
            productNew.setQuantity(productNew.getQuantity() + 1);
        } else {
            productNew = new Product(this.tmpProductCode, this.tmpProductName, 
                    Double.parseDouble(this.tmpProductPrice), 1);
        }
        this.productMap.put(productNew.getCode(), productNew);

        return "cart";
    }
    
    public String remove() {
        if(this.productMap.containsKey(this.tmpProductCode)) {
            Product product = this.productMap.get(this.tmpProductCode);
            if (product.getQuantity() == 1) {
                this.productMap.remove(this.tmpProductCode);
            } else if (product.getQuantity() > 1) {
                product.setQuantity(product.getQuantity() - 1);
                this.productMap.put(product.getCode(), product);
            }
        } 

        return "cart";
    }
    

    public String getTmpProductCode() {
        return tmpProductCode;
    }

    public void setTmpProductCode(String tmpProductCode) {
        this.tmpProductCode = tmpProductCode;
    }

    public String getTmpProductName() {
        return tmpProductName;
    }

    public void setTmpProductName(String tmpProductName) {
        this.tmpProductName = tmpProductName;
    }

    public String getTmpProductPrice() {
        return tmpProductPrice;
    }

    public void setTmpProductPrice(String tmpProductPrice) {
        this.tmpProductPrice = tmpProductPrice;
    }
    
    
    
}
