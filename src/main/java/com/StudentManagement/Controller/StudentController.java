package com.StudentManagement.Controller;

import com.StudentManagement.Model.course;
import com.StudentManagement.Model.student;
import com.StudentManagement.Model.studentcourse;
import com.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/{course_id}/students")
    public List<student> getStudentforCourse(@PathVariable(name = "course_id") int id)
    {
        return studentService.getStudentforCourse(id);
    }

    @PostMapping("/students/{student_id}/course/{course_id}")
    public void insert(@PathVariable(name = "student_id") int id1, @PathVariable(name = "course_id") int id)
    {
       studentService.insert(id1, id);
    }
    @PutMapping("/students/{student_id}/course/{course_id}")
    public void Assignstudenttocourse(@PathVariable(name = "student_id") int id1, @PathVariable(name = "course_id") int id)
    {
       studentService.Assignstudenttocourse(id1, id);
    }

    @DeleteMapping("/students/{student_id}/course/{course_id}")
    public void delete(@PathVariable(name = "student_id") int id1, @PathVariable(name = "course_id") int id)
    {
        studentService.delete(id1, id);
    }

    @PostMapping("/students")
    public student createStudent(@RequestBody student student)
    {
        return studentService.createStudent(student);
    }
}
