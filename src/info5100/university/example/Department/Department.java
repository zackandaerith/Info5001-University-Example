/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author Zheng Fang
 */
public class Department {

    String name; // e.g. MGEN
    CourseCatalog courseCatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    
    ArrayList<Degree> degreeList;
    ArrayList<CourseSchedule> masterCourseSchedule; // Course Schedule for Many Semesters

    public Department(String n) {
        name = n;
        masterCourseSchedule = new ArrayList<CourseSchedule>();
        courseCatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        degreeList = new ArrayList<Degree>();
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, courseCatalog);
        masterCourseSchedule.add(cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        for (CourseSchedule cs : masterCourseSchedule){
            if (cs.getSemester().equals(semester)) return cs;
        }
        
        return null;

    }

    public CourseCatalog getCourseCatalog() {

        return courseCatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = courseCatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = this.getCourseSchedule(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = this.getCourseSchedule(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
    
    public Degree getDegree(String n){
        for (Degree d : degreeList){
            if (d.getName().equals(n)) return d;
        }
        return null;
    }
    
    public void addDegree(Degree d){
        degreeList.add(d);
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonDirectory getPersondirectory() {
        return persondirectory;
    }

    public void setPersondirectory(PersonDirectory persondirectory) {
        this.persondirectory = persondirectory;
    }

    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }

    public void setStudentdirectory(StudentDirectory studentdirectory) {
        this.studentdirectory = studentdirectory;
    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public void setFacultydirectory(FacultyDirectory facultydirectory) {
        this.facultydirectory = facultydirectory;
    }

    public EmployerDirectory getEmployerdirectory() {
        return employerdirectory;
    }

    public void setEmployerdirectory(EmployerDirectory employerdirectory) {
        this.employerdirectory = employerdirectory;
    }

    public ArrayList<Degree> getDegreeList() {
        return degreeList;
    }

    public void setDegreeList(ArrayList<Degree> degreeList) {
        this.degreeList = degreeList;
    }

    public ArrayList<CourseSchedule> getMasterCourseSchedule() {
        return masterCourseSchedule;
    }

    public void setMasterCourseSchedule(ArrayList<CourseSchedule> masterCourseSchedule) {
        this.masterCourseSchedule = masterCourseSchedule;
    }

    public void setCourseCatalog(CourseCatalog courseCatalog) {
        this.courseCatalog = courseCatalog;
    }
    
    public void printCoursesWeTeach(){
        System.out.println("Department: " + this.name +" teaches the following courses: " );
        this.courseCatalog.printCourseList();
    }

    public void printCourseCapacity() {
        System.out.println("Department: " + this.name +" has the following capacity: " );
        for (CourseSchedule cs : masterCourseSchedule){
            cs.printCourseOffers();
        }       
        
    }
    
    public void printStudentCount() {
        System.out.println("Department: " + this.name +" has the following number of students: " );
        for (CourseSchedule cs : masterCourseSchedule){
            cs.printStudentNumber();
        }       
        
    }
}
