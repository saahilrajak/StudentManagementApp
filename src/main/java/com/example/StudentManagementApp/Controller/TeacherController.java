package com.example.StudentManagementApp.Controller;

import com.example.StudentManagementApp.Model.Teacher;
import com.example.StudentManagementApp.Services.TeacherService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping()
    public String addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @GetMapping
    public Teacher getTeacherById(@RequestParam("id") int id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/id/{id}")
    public Teacher getTeacherByIdPath(@PathVariable("id") int id){
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/id/{id}/salary/{salary}")
    public String updateSalaryByPath(@PathVariable("id") int id, @PathVariable("salary") int salary){
        return teacherService.updateSalary(id,salary);
    }

    @PutMapping
    public String updateSalary(@RequestParam("id") int id, @RequestParam("salary") int salary){
        return teacherService.updateSalary(id,salary);
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @DeleteMapping("/id/{id}")
    public String deleteTeacher(@PathVariable("id") int id){
        return teacherService.deleteTeacher(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllTeachers(){
       return teacherService.deleteAllTeacher();
    }

}
