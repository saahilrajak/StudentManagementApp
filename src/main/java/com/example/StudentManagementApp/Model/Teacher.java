package com.example.StudentManagementApp.Model;

import lombok.extern.slf4j.Slf4j;


public class Teacher {
    private int id;
    private String name;
    private int salary;
    private String course;

    Teacher(){

    }

    public Teacher(int id, String name, int salary, String course){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.course = course;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }

    public String getCourse(){
        return course;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public void setCourse(String course){
        this.course = course;
    }
}
