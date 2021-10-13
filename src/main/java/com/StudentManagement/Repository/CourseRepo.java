package com.StudentManagement.Repository;


import com.StudentManagement.Model.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<course,Integer>
{
    course findById(int id);
    //course save(int course_id);
   // course findByIdAndcourseId(int id,int course_id);
}
