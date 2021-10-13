package com.StudentManagement.Service;

import com.StudentManagement.Exception.StudentNotFoundException;
import com.StudentManagement.Model.course;
import com.StudentManagement.Model.student;
import com.StudentManagement.Model.studentcourse;
import com.StudentManagement.Repository.CourseRepo;
import com.StudentManagement.Repository.StudentRepo;
import com.StudentManagement.Repository.studentCourseRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private studentCourseRepo studentCourseRepo;

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    private Object val;

    public List<course> getCourseForStudent(int id) {
        List name = new ArrayList();

        student su = studentRepo.findById(id);
        if (su != null) {
            return su.getCourses();
        } else if (su == null) {
            logger.error("Student not registered,error thrown");
            throw new StudentNotFoundException("Studeny not found with this id");
        }
        List<course> courses = su.getCourses();
        for (course Courses : courses) {
            name.add(Courses.getName());
        }
        return name;
        //function end
    }

    public List<student> getStudentforCourse(int id) {
        List name = new ArrayList<student>();

        course st = courseRepo.findById(id);
        List<student> students = st.getStudents();
        for (student Students : students) {
            name.add(Students.getFirst_name());
            name.add(Students.getLast_name());
            name.add(Students.getDOB());
            name.add(Students.getGender());
        }
        return name;
    }

    public void insert(int student_id, int course_id)
    {
      // studentCourseRepo.insertstudents(student_id,course_id);

        studentcourse ob=new studentcourse();
        ob.setStudent_id(student_id);
        ob.setCourse_id(course_id);
        studentCourseRepo.save(ob);
    }
    public course Assignstudenttocourse(int id, int course_id) {
        //courseRepo.findByIdAndcourseId(id,course_id);
        //courseRepo.deleteById(course_id);
        // List name=new ArrayList<course>();
        List<course> user = studentRepo.findById(id).getCourses();
        course course = null;
        for (course Courses : user) {
            Courses.getId();
            // name.add(Courses.setId(course_id));
            course c = new course();
            c.setId(course_id);
        }
        return course;

    }

    public void delete(int student_id, int course_id) {
       /* student user = studentRepo.findById(student_id);
        List<course> c = user.getCourses();
        int com = 0;
        for (course Course : c) {
            com = Course.getId();
        }
        if (com == course_id)
        {

        }*/
       studentcourse del=new studentcourse();
        del.setStudent_id(student_id);
        del.setCourse_id(course_id);
        studentCourseRepo.delete(del);
    }
    public student createStudent(student student)
    {
                List<course> courseList =student.getCourses();

                if(!CollectionUtils.isEmpty(courseList))
                {
                    for(course ref:courseList)
                    {
                        createCourse(ref);
                    }
                }
         student st=studentRepo.save(student);
                return st;
    }
    public course  createCourse(course cs)
    {
          course data=courseRepo.save(cs);
          return data;
    }
}
