package com.Project2.StudentsData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/project2")
    public String project2()
    {
        return "<b>Welcome to Palwasha's Project 2";
    }

    /**
     *   URL :  http://localhost:8080/students
     * @return all students
     * @throws IOException
     */
    @GetMapping("/students")
    public String  students() throws IOException {
        List<Student> students= readData();
        String print="Student List:<br>-------------------------<br>";
        for(Student student : students){
            print=print+student.toString()+"<br>-------------------------<br>";
        }
        return print;
    }

    /***
     * http://localhost:8080/name/Caleb
     * @param name
     * @return Student
     * @throws IOException
     */
    @GetMapping("/name/{name}")
    public String  student(@PathVariable String name) throws IOException {
        System.out.println("Searching Student by name : "+name);
        List<Student>  students = readData();
        for(Student student : students){
            if( student.getFirst_name().equalsIgnoreCase(name)){
                System.out.println("Found Student "+student);
                return student.toString();
            }
        }
        System.out.println(" Sorry! No Student found for name "+name);
        return " Sorry! No Student found for name "+name;
    }

    //  http://localhost:8080/student?gpa=3.4&gender=male
    @GetMapping("/student")
    public String  student(@RequestParam Double gpa, @RequestParam String gender) throws IOException {
        System.out.println("Searching student by GPA : "+gpa+" And Gender : "+gender);
        List<Student>  students = readData();
        for(Student student : students){
            if( student.getGpa()==gpa & student.getGender().equalsIgnoreCase(gender)){
                System.out.println("Found student "+student);
                return student.toString();
            }
        }
        System.out.println(" Sorry! No student found for GPA "+gpa+" and Gender "+gender);
        return " Sorry! No student found for GPA "+gpa+" and Gender "+gender;
    }

    //  http://localhost:8080/gpa
    @GetMapping("/gpa")
    public String  student() throws IOException {
        List<Student>  students = readData();
        Double gpa=0.0;
        for(Student student : students){
            gpa=gpa+student.getGpa();
        }
        gpa=gpa/students.size();
        return "The average GPA as per the list is: "+gpa.toString();
    }

    /***
     * Read the student.txt file
     * @return all the students
     * @throws IOException
     */
    public List<Student> readData() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/student.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Student> studentList = new ArrayList();

        String header = bufferedReader.readLine(); // read the header
        String line = bufferedReader.readLine(); // read the first line

        while ( line != null){
            String[] data = line.split(",");// split each read line by comma
            Student student = new Student(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),data[3],data[4]);
            studentList.add(student);
            line = bufferedReader.readLine();
        }
        return studentList;
    }
}
