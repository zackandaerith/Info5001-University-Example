/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Zheng Fang
 */
public class Transcript {
    
    StudentProfile student;
    HashMap<String, CourseLoad> courseloadlist;
    
    CourseLoad currentcourseload;
    
    public Transcript(StudentProfile sp){
        student = sp;
        courseloadlist = new HashMap<String, CourseLoad>();
    }
    
    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
        public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
        public float getStudentTotalScore(){
            
            float sum = 0;
 
            for( CourseLoad cl: courseloadlist.values()){
                sum = sum + cl.getSemesterScore();
                
            }
            return sum;
        }
        
        
    public ArrayList<Course> getCoursesTaken(){
        ArrayList<Course> result = new ArrayList<Course>();
        
        for (CourseLoad cl : courseloadlist.values()){
            result.addAll(cl.getCoursesTaken());
        }
        
        return result;
    }
}
