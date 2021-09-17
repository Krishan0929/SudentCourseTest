package com.StudentManagement.Repository;

import com.StudentManagement.Model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<student,Integer>
{
    student findById(int id);
}
