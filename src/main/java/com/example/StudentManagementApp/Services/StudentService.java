package com.example.StudentManagementApp.Services;

import com.example.StudentManagementApp.Exceptions.NotAddedSuccessfully;
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
        if (student == null) {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }
        return student;
    }

    public String addStudent(Student student) {
        String result = studentRepository.addStudent(student);

        if (result.equals("Student exist")) {
            throw new NotAddedSuccessfully("Student already exists.");
        }

        return result;
    }

    public String updateAge(int id, int age) {
        return studentRepository.updateAge(id,age);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public String deleteStudent(int id) {
        String result = studentRepository.deleteStudent(id);

        if (result.equals("Invalid id")) {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }
        return result;
    }
}