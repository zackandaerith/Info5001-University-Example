/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.Department.Degree;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;

/**
 *
 * @author Zheng Fang
 */
public class StudentProfile {

    Person person;
    Degree degree;
    Transcript transcript;
    EmploymentHistroy employmenthistory;
    

    public StudentProfile(Person p) {

        person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public Transcript getTranscript(){
        return transcript;
    }


    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s){
        
        return transcript.newCourseLoad(s);
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    
    public boolean hasFulfilledDegreeRequirements(){
        
        // 1. Check the required courses
        boolean requiredCourseReqMet = true;
        
        for (Course c : degree.getRequired()){
            if (!transcript.getCoursesTaken().contains(c))
                requiredCourseReqMet = false;
        }
        
        // 2. Electives & Credit Hours
        
        int totalCredits = 0;
        for (Course c : transcript.getCoursesTaken()){
            if ((degree.getRequired().contains(c)) || (degree.getElectives().contains(c))){
                totalCredits += c.getCredits();
            }
        }    
        
        boolean creditHoursReqMet = (totalCredits >= 20);
        
        return requiredCourseReqMet && creditHoursReqMet;
    }
    
}
