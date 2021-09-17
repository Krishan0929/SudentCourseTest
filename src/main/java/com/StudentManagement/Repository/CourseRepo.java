package com.StudentManagement.Repository;


import com.StudentManagement.Model.course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<course,Integer> {
}
