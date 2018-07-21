/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.Transient;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.*;

/**
 *
 * @author ahmetay
 */

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{

    private Object user;

    @ManagedProperty("#{applicationTypeBean}")
    private ApplicationTypeBean applicationTypeBean;

    public UserBean() {
    }
    
    public boolean isInstructor(){
        return user instanceof Instructor;
    }
    
    public boolean isStudent(){
        return user instanceof Student;
    }
    
    public boolean isAdministrator(){
        return user instanceof Administrator;
    }
    
    public String getUserInfoMessage(){
        return "Application Type : " + applicationTypeBean.getApplicationTypeText() + " / " + "User Type : " + getUserType();
    }
    
    public String getUserType(){
        if (isStudent()) {
           return "Student"; 
        }
        if (isInstructor()) {
           return "Instructor"; 
        }
        if (isAdministrator()) {
           return "Administrator"; 
        }
        return "Unexpected Type";
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public ApplicationTypeBean getApplicationTypeBean() {
        return applicationTypeBean;
    }

    public void setApplicationTypeBean(ApplicationTypeBean applicationTypeBean) {
        this.applicationTypeBean = applicationTypeBean;
    }
       
    
}
