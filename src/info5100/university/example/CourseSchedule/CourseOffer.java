/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author Zheng Fang
 */
public class CourseOffer {
    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }
    
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }


    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }

    public void putGrade(SeatAssignment sa, float grade){
        
        for (Seat s : seatlist) {
            if (s.getSeatassignment().equals(s)) s.setGrade(grade);
        }
        
        
    }

    public void printSeatCapacity() {
        
        int seatCapacity = seatlist.size();
        this.course.printOut();
        System.out.println(" has " + seatCapacity + " seats.");
    }
    
    public void printStudentNumber() {
        
        this.course.printOut();
        int seatCapacity = seatlist.size(); 
        int occupiedSeatCount = this.countOccupiedSeats();
        System.out.println(" has " + occupiedSeatCount + " number of students from " + seatCapacity + " possible.");
    }

    private int countOccupiedSeats() {
        int count = 0;
        for (Seat s : seatlist){
            if (s.isOccupied()) count++;
        }
        return count;
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
