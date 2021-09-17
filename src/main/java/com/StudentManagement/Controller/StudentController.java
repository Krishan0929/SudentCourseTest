package com.StudentManagement.Controller;

import com.StudentManagement.Model.course;
import com.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    public StudentService studentService;

    @GetMapping("/students/{student_id}/courses")
    public List<course> getCoursesForstudentId(@PathVariable(name = "student_id") int id)
    {
        return studentService.getCourseForStudent(id);
    }
}
