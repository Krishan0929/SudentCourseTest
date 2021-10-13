package com.StudentManagement.Repository;

import com.StudentManagement.Model.studentcourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface studentCourseRepo extends JpaRepository<studentcourse,Integer>
{
    studentcourse findById(int id);

    /*//studentcourse deletecourseById(int course_id);
    @Query(value = "INSERT INTO student_course(student_id,course_id)values(student_id,course_id),nativeQuery = true")
    studentcourse insertstudents(@Param(value = "student_id") int idstudent, @Param(value = "course_id") int idcourse );*/

   /* void add(int student_id,int course_id);*/
}
