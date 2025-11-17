package com.example.StudentManagementApp.Controller;

import com.example.StudentManagementApp.Exceptions.NotAddedSuccessfully;
import com.example.StudentManagementApp.Exceptions.StudentNotFoundException;
import com.example.StudentManagementApp.Model.Student;
import com.example.StudentManagementApp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome Student";
    }

    @GetMapping
    public ResponseEntity getStudentById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity(studentService.getStudentById(id), HttpStatus.OK);
        }
        catch (StudentNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity(studentService.addStudent(student), HttpStatus.CREATED);
        }
        catch (NotAddedSuccessfully e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.ALREADY_REPORTED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudentByIdPath(@PathVariable("id") int id) {
        try {
            return new ResponseEntity(studentService.getStudentById(id), HttpStatus.OK);
        }
        catch (StudentNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/id/{id}/age/{age}")
    public String updateAge(@PathVariable("id") int id,
                                    @PathVariable("age") int age) {
       return studentService.updateAge(id,age);
    }

    @PutMapping
    public ResponseEntity updateAgeByRequestParam(@RequestParam("id") int id,
                                                  @RequestParam("age") int age) {
        try {
            return new ResponseEntity(studentService.updateAge(id, age), HttpStatus.OK);
        }
        catch (StudentNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllStudents() {
        try {
            return new ResponseEntity(studentService.getAllStudents(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity("No students found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestParam("id") int id) {
        try {
            return new ResponseEntity(studentService.deleteStudent(id), HttpStatus.OK);
        }
        catch (StudentNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
