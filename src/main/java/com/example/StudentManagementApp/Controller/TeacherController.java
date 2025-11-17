package com.example.StudentManagementApp.Controller;

import com.example.StudentManagementApp.Exceptions.NotAddedSuccessfully;
import com.example.StudentManagementApp.Exceptions.TeacherNotFoundException;
import com.example.StudentManagementApp.Model.Student;
import com.example.StudentManagementApp.Model.Teacher;
import com.example.StudentManagementApp.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    // CREATE
    @PostMapping
    public ResponseEntity addTeacher(@RequestBody Teacher teacher) {
        try {
            return new ResponseEntity(teacherService.addTeacher(teacher), HttpStatus.CREATED);
        }
        catch (NotAddedSuccessfully e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET BY REQUEST PARAM
    @GetMapping
    public ResponseEntity getTeacherById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity(teacherService.getTeacherById(id), HttpStatus.OK);
        }
        catch (TeacherNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET BY PATH VARIABLE (NO RESPONSEENTITY as per your structure)
    @GetMapping("/id/{id}")
    public Teacher getTeacherByIdPath(@PathVariable("id") int id) {
        return teacherService.getTeacherById(id);
    }

    // UPDATE BY PATH
    @PutMapping("/id/{id}/salary/{salary}")
    public ResponseEntity updateSalaryByPath(@PathVariable("id") int id,
                                             @PathVariable("salary") int salary) {
        try {
            return new ResponseEntity(teacherService.updateSalary(id, salary), HttpStatus.OK);
        }
        catch (TeacherNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // UPDATE BY REQUEST PARAM
    @PutMapping
    public ResponseEntity updateSalary(@RequestParam("id") int id,
                                       @RequestParam("salary") int salary) {
        try {
            return new ResponseEntity(teacherService.updateSalary(id, salary), HttpStatus.OK);
        }
        catch (TeacherNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteTeacher(@PathVariable("id") int id) {
        try {
            return new ResponseEntity(teacherService.deleteTeacher(id), HttpStatus.OK);
        }
        catch (TeacherNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllTeachers(){
        return teacherService.deleteAllTeacher();
    }
}
