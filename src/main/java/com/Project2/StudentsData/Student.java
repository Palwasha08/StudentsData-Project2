package com.Project2.StudentsData;

public class Student {
    private int id;
    private String first_name;
    private double gpa;
    private String email;
    private String gender;
    public Student(int id, String first_name, double gpa, String email, String gender) {
        this.id = id;
        this.first_name = first_name;
        this.gpa = gpa;
        this.email = email;
        this.gender = gender;
    }
    public Student() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Student_id: " + id + ",<br>First name: " + first_name + ",<br>GPA: " + gpa + ",<br>Email: " + email + ",<br>Gender: "
                + gender ;
    }
}
