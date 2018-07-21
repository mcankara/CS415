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
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmetay
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class PageRouterBean implements Serializable {

    public static final long serialVersionUID = 76876595498384L;

    @ManagedProperty("#{applicationTypeBean}")
    private ApplicationTypeBean applicationTypeBean;

    @PostConstruct
    public void init() {

    }

    public void redirectToSchedule() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            if (applicationTypeBean.isPrimary()) {
                context.getExternalContext().redirect("schedule_primary.xhtml");
                context.responseComplete();
            } else if (applicationTypeBean.isHighSchool()) {
                context.getExternalContext().redirect("schedule_high.xhtml");
                context.responseComplete();
            } else if (applicationTypeBean.isUniversity()) {
                context.getExternalContext().redirect("schedule_university.xhtml");
                context.responseComplete();
            } else {
                throw new Exception("Unexpected Application Type");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ApplicationTypeBean getApplicationTypeBean() {
        return applicationTypeBean;
    }

    public void setApplicationTypeBean(ApplicationTypeBean applicationTypeBean) {
        this.applicationTypeBean = applicationTypeBean;
    }

}
