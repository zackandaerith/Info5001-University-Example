/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import java.util.ArrayList;

/**
 *
 * @author Zheng Fang
 */
public class Degree {
    
    Department department;
    String name;
    ArrayList<Course> required;
    ArrayList<Course> electives;
    int credits; 

    public Degree(Department department, String name) {
        this.department = department;
        this.name = name;
        required = new ArrayList<Course>();
        electives = new ArrayList<Course>();
        
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRequired() {
        return required;
    }

    public ArrayList<Course> getElectives() {
        return electives;
    }

    public int getCredits() {
        return credits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void addRequiredCourse(Course c){
        if (c != null)
            required.add(c);
    }
    
    public void addElectiveCourse(Course c){
        if (c != null)
            electives.add(c);
    }
}
