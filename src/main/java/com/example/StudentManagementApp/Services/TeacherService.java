package com.example.StudentManagementApp.Services;

import com.example.StudentManagementApp.Exceptions.NotAddedSuccessfully;
import com.example.StudentManagementApp.Exceptions.TeacherNotFoundException;
import com.example.StudentManagementApp.Model.Teacher;
import com.example.StudentManagementApp.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    // ADD
    public String addTeacher(Teacher teacher) {
        String result = teacherRepository.addTeacher(teacher);

        if (result.equals("Teacher exist")) {
            throw new NotAddedSuccessfully("Teacher already exists.");
        }

        return result;
    }

    public Teacher getTeacherById(int id) {
        Teacher teacher = teacherRepository.getTeacherById(id);

        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher with id " + id + " not found.");
        }

        return teacher;
    }

    public Teacher getTeacherByIdPath(int id) {
        Teacher teacher = teacherRepository.getTeacherById(id);

        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher with id " + id + " not found.");
        }

        return teacher;
    }

    public String updateSalaryByPath(int id, int salary) {
        String result = teacherRepository.updateSalary(id, salary);

        if (result.equals("Invalid ID")) {
            throw new TeacherNotFoundException("Teacher with id " + id + " not found.");
        }

        return result;
    }

    public String updateSalary(int id, int salary) {
        String result = teacherRepository.updateSalary(id, salary);

        if (result.equals("Invalid ID")) {
            throw new TeacherNotFoundException("Teacher with id " + id + " not found.");
        }

        return result;
    }

    public List<Teacher> getAllTeacher() {
        return teacherRepository.getAllTeacher();
    }


    public String deleteTeacher(int id) {
        String result = teacherRepository.deleteTeacher(id);

        if (result.equals("Invalid Id")) {
            throw new TeacherNotFoundException("Teacher with id " + id + " not found.");
        }

        return result;
    }

    public String deleteAllTeacher() {
        return teacherRepository.deleteAllTeacher();
    }
}
