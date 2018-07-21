/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ahmetay
 */
public class ClassModel {
    private int classId;
    private String className;
    private ArrayList<PreUniStudent> studentList;
    
    private Course[][] courseChart;

    public ClassModel(int classId, String className, int dayCount, int dailyCourseCount) {
        this.classId = classId;
        this.className = className;
        
        courseChart = new Course[dailyCourseCount][dayCount];
    }

    @Override
    public String toString() {
        return className;
    }
    
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public ArrayList<PreUniStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<PreUniStudent> studentList) {
        this.studentList = studentList;
    }

    public Course[][] getCourseChart() {
        return courseChart;
    }

    public void setCourseChart(Course[][] courseChart) {
        this.courseChart = courseChart;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    
    
}
