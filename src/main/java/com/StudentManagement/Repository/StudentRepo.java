package com.StudentManagement.Repository;

import com.StudentManagement.Model.student;
import com.StudentManagement.Model.studentcourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<student,Integer>
{
    student findById(int id);

    /*@Query(value = "INSERT INTO student_course (SELECT  student.student_id, course.course_id FROM \n" +
            "student CROSS JOIN course),nativeQuery = true")
    studentcourse insertstudents(@Param(value = "student_id") int student_id,@Param(value = "course_id") int course_id );*/

}
