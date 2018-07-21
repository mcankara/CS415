/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Course;

/**
 *
 * @author ahmetay
 */
@ManagedBean(name = "scheduleBean")
@ViewScoped
public class ScheduleBean implements Serializable {

    public static final long serialVersionUID = 65754365498384L;

    private Course[][] courseChart = new Course[10][7];

    @PostConstruct
    public void init() {
        
        
        
    }

    public Course[][] getCourseChart() {
        return courseChart;
    }

    public void setCourseChart(Course[][] courseChart) {
        this.courseChart = courseChart;
    }
    
    

}
