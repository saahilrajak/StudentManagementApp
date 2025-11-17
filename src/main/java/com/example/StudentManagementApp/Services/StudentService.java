package com.example.StudentManagementApp.Services;

import com.example.StudentManagementApp.Exceptions.StudentNotFoundException;
import com.example.StudentManagementApp.Repository.StudentRepository;
import com.example.StudentManagementApp.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(int id) {
        Student student = studentRepository.getStudentById(id);
        if(student == null){
            throw new StudentNotFoundException("Student with Id" + id + "Not found");
        }
        return studentRepository.getStudentById(id);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String updateAge(int id, int age) {
        return studentRepository.updateAge(id, age);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}