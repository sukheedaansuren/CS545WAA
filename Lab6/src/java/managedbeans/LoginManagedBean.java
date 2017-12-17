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
@Named(value = "loginManagedBean")
@RequestScoped
public class LoginManagedBean {

    private String userId;
    private String password;
    
    public String login() {
        if("kl01".equals(this.userId) && "yoyo".equals(this.password)) {
            return "success";
        }
        return "failure";
    }   
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
