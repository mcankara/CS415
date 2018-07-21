/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ahmetay
 */
@ManagedBean(name = "dashboardBean")
@ViewScoped
public class DashboardBean implements Serializable {

    public static final long serialVersionUID = 65754365498384L;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;
    
    @PostConstruct
    public void init() {
        
    }
    
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

}
