package com.example.firebaseapp;

import java.io.Serializable;

public class Grade implements Serializable {

    int course_id;
    String course_name;
    String grade;
    int student_id;

    public Grade(){}

    public Grade(int course, String name, String grad, int ID){
        course_id = course;
        course_name = name;
        grade = grad;
        student_id = ID;
    }

    public int getCourse_id(){
        return course_id;
    }
    public String getCourse_name(){
        return course_name;
    }
    public String getGrade(){
        return grade;
    }
    public int getStudent_id(){
        return student_id;
    }

}
