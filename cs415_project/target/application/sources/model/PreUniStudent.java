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
public abstract class PreUniStudent extends Student {

    protected Role role;
    protected ClassModel classOfStudent;

    public PreUniStudent(Role role, ClassModel classOfStudent, int studentId, String name, double gpa) {
        super(studentId, name, gpa);
        this.role = role;
        this.classOfStudent = classOfStudent;
    }

    public enum Role {
        NO_ROLE("No Role"), HALL_MONITOR("Hall Monitor"), CLASS_PRESIDENT("Class President"), HELPER("Helper");

        private final String roleName;

        Role(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }
    }
    
    public void seePTA(){
        //TODO
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int getStudentId() {
        return studentId;
    }

    @Override
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public ClassModel getClassOfStudent() {
        return classOfStudent;
    }

    public void setClassOfStudent(ClassModel classOfStudent) {
        this.classOfStudent = classOfStudent;
    }

}
