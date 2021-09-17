package com.StudentManagement.Service;

import com.StudentManagement.Exception.StudentNotFoundException;
import com.StudentManagement.Model.course;
import com.StudentManagement.Model.student;
import com.StudentManagement.Repository.CourseRepo;
import com.StudentManagement.Repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService
{
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    private static Logger logger= LoggerFactory.getLogger(StudentService.class);

    public List<course> getCourseForStudent(int id)
    {
        List name=new ArrayList();

        student su=studentRepo.findById(id);
        if(su!=null)
        {
            return su.getCourses();
        }else if(su==null)
        {
            logger.error("Student not registered,error thrown");
            throw new StudentNotFoundException("Studeny not found with this id");
        }
        List<course> courses=su.getCourses();
        for(course Courses:courses)
        {
            name.add(Courses.getName());
        }
        return name;
    }
}
