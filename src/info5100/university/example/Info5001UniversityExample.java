/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Degree;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Zheng Fang
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // 0. Populate the model

        Department mgen = new Department("MGEN");
        CourseCatalog mgenCC = mgen.getCourseCatalog();

        Course info5001 = mgenCC.newCourse("Application Modelling & Design", "INFO5001", 4);
        Course info5100 = mgenCC.newCourse("Application Engineering", "INFO5100", 4);
        Course info6105 = mgenCC.newCourse("Data Science Tools", "INFO6105", 4);
        Course info6150 = mgenCC.newCourse("Web Degign & User Experience", "INFO6150", 4);
        Course info6205 = mgenCC.newCourse("Prgram Structure", "INFO6205", 4);
        Course info6215 = mgenCC.newCourse("Business Analysis", "INFO6215", 4);
        Course info6245 = mgenCC.newCourse("Information System Development", "INFO6245",4);
        Course info6250 = mgenCC.newCourse("Web Development", "INFO6250", 4);
        Course info6255 = mgenCC.newCourse("Software Quality", "INFO6255",4);
        Course info6350 = mgenCC.newCourse("Smartphones-WB development", "INFO6350", 4);
        Course info6660 = mgenCC.newCourse("Business Ethics", "INFO6660", 4);



        // 1. What are the courses we teach?

//        System.out.println("1. What are the courses we teach?");
//
//        mgen.printCoursesWeTeach(); // Prints out the list of courses a department teaches

        // 2. What is our current capacity? How many seats are empty? 

//        System.out.println("\n2. What is our current capacity? How many seats are empty?");

        CourseSchedule mgenFall2021 = mgen.newCourseSchedule("Fall 2021");
        CourseSchedule mgenFall2020 = mgen.newCourseSchedule("Fall 2020");
        CourseSchedule mgenFall2019 = mgen.newCourseSchedule("Fall 2019");

        CourseOffer coInfo5001 = mgenFall2019.newCourseOffer(info5001.getCOurseNumber());
        CourseOffer coInfo5100 = mgenFall2020.newCourseOffer(info5100.getCOurseNumber());
        CourseOffer coInfo6105 = mgenFall2019.newCourseOffer(info6105.getCOurseNumber());
        CourseOffer coInfo6215 = mgenFall2020.newCourseOffer(info6215.getCOurseNumber());

        CourseOffer coInfo6245 = mgenFall2020.newCourseOffer(info6245.getCOurseNumber());
        CourseOffer coInfo6250 = mgenFall2020.newCourseOffer(info6250.getCOurseNumber());
        CourseOffer coInfo6255 = mgenFall2021.newCourseOffer(info6255.getCOurseNumber());
        CourseOffer coInfo6350 = mgenFall2021.newCourseOffer(info6350.getCOurseNumber());
        CourseOffer coInfo6205 = mgenFall2019.newCourseOffer(info6205.getCOurseNumber());

        CourseOffer coInfo6660 = mgenFall2021.newCourseOffer(info6660.getCOurseNumber());
        CourseOffer coInfo6150 = mgenFall2019.newCourseOffer(info6150.getCOurseNumber());




        coInfo5001.generatSeats(20);
        coInfo5100.generatSeats(30);
        coInfo6105.generatSeats(15);
        coInfo6215.generatSeats(25);
        coInfo6245.generatSeats(20);
        coInfo6250.generatSeats(20);
        coInfo6255.generatSeats(24);
        coInfo6350.generatSeats(26);
        coInfo6205.generatSeats(28);
        coInfo6660.generatSeats(20);
        coInfo6150.generatSeats(20);

//        mgen.printCourseCapacity();

        // 3. What is the average number of students per class?
//        System.out.println();
//        System.out.println("\n3. What is the number of students per class?");


//        ArrayList<Person> persons = new ArrayList<Person>();
        PersonDirectory mgenPD = mgen.getPersonDirectory();
        Person person1 = mgenPD.newPerson("00001");
        Person person2 = mgenPD.newPerson("00002");
        Person person3 = mgenPD.newPerson("00003");
        Person person4 = mgenPD.newPerson("00004");
        Person person5 = mgenPD.newPerson("00005");

        StudentDirectory mgenSD = mgen.getStudentDirectory();
        StudentProfile student1 = mgenSD.newStudentProfile(person1);
        StudentProfile student2 = mgenSD.newStudentProfile(person2);
        StudentProfile student3 = mgenSD.newStudentProfile(person3);
        StudentProfile student4 = mgenSD.newStudentProfile(person4);
        StudentProfile student5 = mgenSD.newStudentProfile(person5);

        CourseLoad courseload12021 = student1.newCourseLoad("Fall 2021");
        CourseLoad courseload22021 = student2.newCourseLoad("Fall 2021");
        CourseLoad courseload32021 = student3.newCourseLoad("Fall 2021");
        CourseLoad courseload42021 = student4.newCourseLoad("Fall 2021");
        CourseLoad courseload52021 = student5.newCourseLoad("Fall 2021");
        CourseLoad courseload12020 = student1.newCourseLoad("Fall 2020");
        CourseLoad courseload22020 = student2.newCourseLoad("Fall 2020");
        CourseLoad courseload32020 = student3.newCourseLoad("Fall 2020");
        CourseLoad courseload42020 = student4.newCourseLoad("Fall 2020");
        CourseLoad courseload52020 = student5.newCourseLoad("Fall 2020");
        CourseLoad courseload12019 = student1.newCourseLoad("Fall 2019");
        CourseLoad courseload22019 = student2.newCourseLoad("Fall 2019");
        CourseLoad courseload32019 = student3.newCourseLoad("Fall 2019");
        CourseLoad courseload42019 = student4.newCourseLoad("Fall 2019");
        CourseLoad courseload52019 = student5.newCourseLoad("Fall 2019");

        courseload12019.newSeatAssignment(coInfo5001).setGrade(4.0F);
        courseload22019.newSeatAssignment(coInfo5001).setGrade(4.0F);
        courseload32019.newSeatAssignment(coInfo5001).setGrade(4.0F);
        courseload42019.newSeatAssignment(coInfo5001).setGrade(4.0F);
        courseload52019.newSeatAssignment(coInfo5001).setGrade(4.0F);

        courseload12019.newSeatAssignment(coInfo6105).setGrade(4.0F);
        courseload22019.newSeatAssignment(coInfo6105).setGrade(4.0F);
        courseload32019.newSeatAssignment(coInfo6105).setGrade(4.0F);
        courseload42019.newSeatAssignment(coInfo6105).setGrade(4.0F);
        courseload52019.newSeatAssignment(coInfo6105).setGrade(4.0F);

        courseload12020.newSeatAssignment(coInfo5100).setGrade(4.0F);
        courseload22020.newSeatAssignment(coInfo5100).setGrade(4.0F);
//        courseload32020.newSeatAssignment(coInfo5100);
        courseload42020.newSeatAssignment(coInfo5100).setGrade(4.0F);
        courseload52020.newSeatAssignment(coInfo5100).setGrade(4.0F);

        courseload12020.newSeatAssignment(coInfo6215).setGrade(4.0F);
        courseload22020.newSeatAssignment(coInfo6215).setGrade(4.0F);
        courseload32020.newSeatAssignment(coInfo6215).setGrade(4.0F);
        courseload42020.newSeatAssignment(coInfo6215).setGrade(4.0F);
        courseload52020.newSeatAssignment(coInfo6215).setGrade(4.0F);

        courseload12021.newSeatAssignment(coInfo6255).setGrade(4.0F);
        courseload22021.newSeatAssignment(coInfo6255).setGrade(4.0F);
        courseload32021.newSeatAssignment(coInfo6255).setGrade(4.0F);
//        courseload42021.newSeatAssignment(coInfo6255);
        courseload52021.newSeatAssignment(coInfo6255).setGrade(4.0F);


        courseload12021.newSeatAssignment(coInfo6350).setGrade(4.0F);
        courseload22021.newSeatAssignment(coInfo6350).setGrade(4.0F);
//        courseload32021.newSeatAssignment(coInfo6350);
        courseload42021.newSeatAssignment(coInfo6350).setGrade(4.0F);
        courseload52021.newSeatAssignment(coInfo6350).setGrade(4.0F);

//        mgen.printStudentCount();


//1. What are the courses we offer at any given semester? 
//Calculate the total revenue of the department by semesters.
//Populate the model (with at least 5 courses) and print the answer to the console.
//Must generate data for multiple semesters and use it to test your design.
//2. What is the current student enrollment in our department?
//Generate data for multiple students to print results to the console.
//3. Show how to determine if a student fulfilled their graduation (degree) requirements.
//Generate sufficient data to show both cases, i.e. students who have & have not fulfilled the requirements.

//There are two ways to do this: one would be for each class they have taken check 
//if that belongs to the core or elective list for the program of study (department). 
//The second is to iterate over the core and elective courses for the degree program and see 
//if they exist in the transcript. Which one would be easier to implement?
//



System.out.println("\n1. What are the courses we offer at any given semester? "
        + "Calculate the total revenue of the department by semesters.");
Scanner scanner = new Scanner(System.in); //Create a scanner for input semester
        while (true) {
            System.out.println("Enter Semester: Ex '2021';  Enter '0' to exit. ");
            int semesterNm = scanner.nextInt();
            if (semesterNm == 2021) {
                mgenFall2021.printCourseOffers();
                System.out.println("Total revenue of MGEN Fall 2021 is " + mgenFall2021.calculateTotalRevenues() + " dollars.");
            }
            if (semesterNm == 2019) {
                mgenFall2019.printCourseOffers();
                System.out.println("Total revenue of MGEN Fall 2019 is " + mgenFall2019.calculateTotalRevenues() + " dollars.");
            }
            if (semesterNm == 2020) {
                mgenFall2020.printCourseOffers();
                System.out.println("Total revenue of MGEN Fall 2020 is " + mgenFall2020.calculateTotalRevenues() + " dollars.");}
            else System.out.println("There is no data, pleas reenter the semester number");

            if (semesterNm == 0) break;
        }
        scanner.close();



        System.out.println("=================================================");
System.out.println("\n2. What is the current student enrollment in our department?");

        System.out.println("Student1 taking following course in Fall 2019 : ");
        for (Course i : student1.getCourseLoadBySemester("Fall 2019").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student1 taking following course in Fall 2020 : ");
        for (Course i : student1.getCourseLoadBySemester("Fall 2020").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student1 taking following course in Fall 2021: ");
        for (Course i : student1.getCourseLoadBySemester("Fall 2021").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student2 taking following course in Fall 2019: ");
        for (Course i : student2.getCourseLoadBySemester("Fall 2019").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student2 taking following course in Fall 2020: ");
        for (Course i : student2.getCourseLoadBySemester("Fall 2020").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student2 taking following course in Fall 2021: ");
        for (Course i : student2.getCourseLoadBySemester("Fall 2021").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student3 taking following course in Fall 2019: ");
        for (Course i : student3.getCourseLoadBySemester("Fall 2019").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student3 taking following course in Fall 2020: ");
        for (Course i : student3.getCourseLoadBySemester("Fall 2020").getCoursesTaken())
            System.out.println(i.getCOurseNumber());

        System.out.println("Student3 taking following course in Fall 2021: ");
        for (Course i : student3.getCourseLoadBySemester("Fall 2021").getCoursesTaken())
            System.out.println(i.getCOurseNumber());


System.out.println("=================================================");


        Degree megndegree = new Degree(mgen,"Information System");
        megndegree.addRequiredCourse(info5001);
        megndegree.addRequiredCourse(info5100);
        megndegree.addRequiredCourse(info6105);
        megndegree.addRequiredCourse(info6215);
        megndegree.addElectiveCourse(info6350);
        megndegree.addElectiveCourse(info6255);
        megndegree.addElectiveCourse(info6205);
        megndegree.addElectiveCourse(info6250);
        megndegree.addElectiveCourse(info6245);
        megndegree.addElectiveCourse(info6660);
        megndegree.setCredits(10);

        student1.setDegree(megndegree);
        student2.setDegree(megndegree);
        student3.setDegree(megndegree);
        student4.setDegree(megndegree);
        student5.setDegree(megndegree);



System.out.println("\n3. Show how to determine if a student fulfilled their graduation (degree) requirements.");

System.out.println("Student 1 complete follwing class :");

for (Course i : student1.getTranscript().getCoursesTaken()) System.out.println(i.getCOurseNumber());

if (student1.hasFulfilledDegreeRequirements()) System.out.println("Student1 has fulfilled his degree!");
else System.out.println("Student1 didnt fulfilled his degree");
System.out.println("-------------------------------");


        System.out.println("Student 2 complete follwing class :");

        for (Course i : student2.getTranscript().getCoursesTaken()) System.out.println(i.getCOurseNumber());

        if (student2.hasFulfilledDegreeRequirements()) System.out.println("Student2 has fulfilled his degree!");
        else System.out.println("Student2 didnt fulfilled his degree");
        System.out.println("-------------------------------");


        System.out.println("Student 3 complete follwing class :");

        for (Course i : student3.getTranscript().getCoursesTaken()) System.out.println(i.getCOurseNumber());

        if (student3.hasFulfilledDegreeRequirements()) System.out.println("Student3 has fulfilled his degree!");
        else System.out.println("Student3 didnt fulfilled his degree");
        System.out.println("-------------------------------");

        System.out.println("Student 1 complete follwing class :");

        for (Course i : student4.getTranscript().getCoursesTaken()) System.out.println(i.getCOurseNumber());

        if (student4.hasFulfilledDegreeRequirements()) System.out.println("Student4 has fulfilled his degree!");
        else System.out.println("Student4 didnt fulfilled his degree");

        System.out.println("-------------------------------");


        System.out.println("Student 5 complete follwing class :");

        for (Course i : student5.getTranscript().getCoursesTaken()) System.out.println(i.getCOurseNumber());

        if (student5.hasFulfilledDegreeRequirements()) System.out.println("Student5 has fulfilled his degree!");
        else System.out.println("Student5 didnt fulfilled his degree");
        System.out.println("-------------------------------");








        
        
        
        
//        Department department = new Department("Information Systems");
//        CourseCatalog coursecatalog = department.getCourseCatalog();
//        
//        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
//        
//        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
//
//        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
//        if (courseoffer!=null)
//        courseoffer.generatSeats(10);
//        
//        PersonDirectory pd = department.getPersonDirectory();
//        Person person = pd.newPerson("0112303");
//        StudentDirectory sd = department.getStudentDirectory();
//        StudentProfile student = sd.newStudentProfile(person);
//        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
////        
//        SeatAssignment sa = courseload.newSeatAssignment(courseoffer); //register student in class
//        sa.setGrade(4.0f);
//        
//        System.out.println(student.getCourseLoadBySemester("Fall2020").getSemesterScore());
//        
        

    }
}

