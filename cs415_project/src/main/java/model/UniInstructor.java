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
public class UniInstructor extends Instructor {

    public UniInstructor(String name) {
        super.name = name;
        courses = new ArrayList<Course>();
    }
    
    public void assignFZ(int studentID){
        //TODO
    }
    
    

}
