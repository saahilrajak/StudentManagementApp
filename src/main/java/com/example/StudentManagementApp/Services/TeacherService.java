package com.example.StudentManagementApp.Services;

import com.example.StudentManagementApp.Model.Teacher;
import com.example.StudentManagementApp.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public String addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }


    public Teacher getTeacherById(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public Teacher getTeacherByIdPath(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public String updateSalaryByPath(int id, int salary) {
        return teacherRepository.updateSalary(id, salary);
    }

    public String updateSalary(int id, int salary) {
        return teacherRepository.updateSalary(id, salary);
    }

    public List<Teacher> getAllTeacher() {
        return teacherRepository.getAllTeacher();
    }

    public String deleteTeacher(int id) {
        return teacherRepository.deleteTeacher(id);
    }

    public String deleteAllTeacher() {
        return teacherRepository.deleteAllTeacher();
    }
}
