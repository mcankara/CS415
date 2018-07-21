/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ahmetay
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ApplicationTypeBean implements Serializable {

    public static final long serialVersionUID = 65754365498384L;

    private ApplicationType applicationType = ApplicationType.UNIVERSITY;


    @PostConstruct
    public void init() {

    }
    
        
    public enum ApplicationType {
        PRIMARY, HIGH, UNIVERSITY;
    }

    public boolean isPrimary(){
        return applicationType == ApplicationType.PRIMARY;
    }
    
    
    public boolean isHighSchool(){
        return applicationType == ApplicationType.HIGH;
    }
    
    public boolean isUniversity(){
        return applicationType == ApplicationType.UNIVERSITY;
    }
    
    public String getApplicationTypeText(){
        if (isPrimary()) {
            return "Primary School";
        }
        if (isHighSchool()) {
            return "High School";
        }
        if (isUniversity()) {
            return "University";
        }
        return "Unexpedted Type";
    }
    

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

}
