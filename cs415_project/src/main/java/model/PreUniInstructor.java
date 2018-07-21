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
public abstract class PreUniInstructor extends Instructor {

    public PreUniInstructor(String name) {
        super.name = name;
        courses = new ArrayList<Course>();
    }
    
    public void enterParticipationGrade(int studentID){
        //TODO
    }
    
    public void contactToParent(int studentID, String title, String messageContent){
        //TODO
    }
    
      
    public void arrangePTA(int studentID){
        //TODO
    }
    

}
