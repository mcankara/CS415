/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.*;
import model.PreUniStudent.Role;

/**
 *
 * @author ahmetay
 */
@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {

    public static final long serialVersionUID = 54645776876584L;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    @ManagedProperty("#{applicationTypeBean}")
    private ApplicationTypeBean applicationTypeBean;

    private ArrayList<Student> students;
    private ArrayList<ClassModel> classList;

    private int studentId;
    private String name;
    private String role;
    private double gpa;
    private String className;

    @PostConstruct
    public void init() {

        // DAO Operations
        students = new ArrayList();

        // DAO Operations
        classList = new ArrayList<ClassModel>();
        for (int i = 1; i <= 12; i++) {
            classList.add(new ClassModel(i, i + "/A", 5, 8));
            classList.add(new ClassModel(i, i + "/B", 5, 8));
            classList.add(new ClassModel(i, i + "/C", 5, 8));
        }
    }

    public void addStudent() {

        if (applicationTypeBean.isPrimary()) {

            PrimaryStudent primaryStudent = new PrimaryStudent(studentId, getClassFromName(className), name, gpa, getRoleFromName(role));
            // DAO Operations
            students.add(primaryStudent);

        } else if (applicationTypeBean.isHighSchool()) {

            HighSchoolStudent highSchoolStudent = new HighSchoolStudent(studentId, getClassFromName(className), name, gpa, getRoleFromName(role));
            // DAO Operations
            students.add(highSchoolStudent);

        } else if (applicationTypeBean.isUniversity()) {
            UniStudent uniStudent = new UniStudent(studentId, name, gpa);
            // DAO Operations
            students.add(uniStudent);
        }
    }

    public ArrayList<String> getRoleList() {
        ArrayList<String> roleList = new ArrayList<String>();
        for (Role role : Role.values()) {
            roleList.add(role.getRoleName());
        }
        return roleList;
    }

    public ClassModel getClassFromName(String className) {
        for (ClassModel cls : classList) {
            if (cls.getClassName().equals(cls)) {
                return cls;
            }
        }
        return null;
    }

    public Role getRoleFromName(String roleName) {
        for (Role role : Role.values()) {
            if (role.getRoleName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
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

    public ArrayList<ClassModel> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<ClassModel> classList) {
        this.classList = classList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
