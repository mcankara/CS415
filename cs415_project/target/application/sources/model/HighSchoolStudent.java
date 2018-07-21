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
public class HighSchoolStudent extends PreUniStudent {


    public HighSchoolStudent(int StudentId, ClassModel classOfStudent, String name, double gpa, Role role) {
        super(role, classOfStudent, StudentId, name, gpa);
    }


}
