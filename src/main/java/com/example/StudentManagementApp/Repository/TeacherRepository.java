package com.example.StudentManagementApp.Repository;

import com.example.StudentManagementApp.Model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TeacherRepository {
    HashMap<Integer, Teacher> teacherDb = new HashMap<>();

    public String addTeacher(Teacher teacher) {
        if(teacherDb.containsKey(teacher.getId())){
            return "Teacher exist";
        }
        teacherDb.put(teacher.getId(),teacher);
        return "Teacher added successfully";
    }


    //get teacher
    public Teacher getTeacherById(int id) {
        if(!teacherDb.containsKey(id)){
            return null;
        }
        return teacherDb.get(id);
    }

    public String updateSalary(int id, int salary){
        if(!teacherDb.containsKey(id)){
            return "Invalid ID";
        }

        Teacher existingTeacher = teacherDb.get(id);
        existingTeacher.setSalary(salary);
        teacherDb.put(id,existingTeacher);
        return "salary Updated Successfully";
    }


    public List<Teacher> getAllTeacher() {
        return new ArrayList<>(teacherDb.values());
    }

    public String deleteTeacher(int id){
        if(!teacherDb.containsKey(id)){
            return "Invalid Id";
        }

        teacherDb.remove(id);
        return "Teacher Deleted Successfully";
    }

    public String deleteAllTeacher() {
        if(teacherDb.isEmpty()) {
            return "No teachers found to delete";
        }

        teacherDb.clear();
        return "All teachers deleted successfully";
    }
}
