/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.*;

/**
 *
 * @author ahmetay
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

    private String userName, password;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    @ManagedProperty("#{applicationTypeBean}")
    private ApplicationTypeBean applicationTypeBean;

    public LoginBean() {
    }

    public void login() {
        System.out.println("bean.LoginBean.login()");

        // DAO operations...
        if (userName.equalsIgnoreCase("Admin")) {
            Administrator admin = new Administrator();
            userBean.setUser(admin);
        } else if (userName.equalsIgnoreCase("student")) {

            if (applicationTypeBean.isHighSchool()) {
                // DAO Operations
                HighSchoolStudent hss = new HighSchoolStudent(1, new ClassModel(0, "10/A", 5, 8), "Ahmet Ay", 4.0, PreUniStudent.Role.CLASS_PRESIDENT);
                userBean.setUser(hss);
            } else if (applicationTypeBean.isPrimary()) {
                // DAO Operations
                PrimaryStudent ps = new PrimaryStudent(1, new ClassModel(0, "4/A", 5, 8), "Ahmet Ay", 4.0, PreUniStudent.Role.CLASS_PRESIDENT);
                userBean.setUser(ps);
            } else if (applicationTypeBean.isUniversity()) {
                // DAO Operations
                UniStudent uniStudent = new UniStudent(1, "Ahmet Ay", 4.0);
                userBean.setUser(uniStudent);
            }

        } else if (userName.equalsIgnoreCase("instructor")) {

            if (applicationTypeBean.isHighSchool()) {
                // DAO Operations
                HighSchoolInstructor hsi = new HighSchoolInstructor("Ahmet Ay");
                userBean.setUser(hsi);
            } else if (applicationTypeBean.isPrimary()) {
                // DAO Operations
                PrimaryInstructor pi = new PrimaryInstructor("Ahmet Ay");
                userBean.setUser(pi);
            } else if (applicationTypeBean.isUniversity()) {
                // DAO Operations
                UniInstructor ui = new UniInstructor("Ahmet Ay");
                userBean.setUser(ui);
            }

        } else {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "  - Invalid user name or password! ", ""));
            return;
        }

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("home_page.xhtml");
            context.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void logout(){
        userBean.setUser(null);
        try {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("login.xhtml");
                context.responseComplete();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void userLoginControl() {
        if (userBean.getUser() == null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("login.xhtml");
                context.responseComplete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public ApplicationTypeBean getApplicationTypeBean() {
        return applicationTypeBean;
    }

    public void setApplicationTypeBean(ApplicationTypeBean applicationTypeBean) {
        this.applicationTypeBean = applicationTypeBean;
    }

}
