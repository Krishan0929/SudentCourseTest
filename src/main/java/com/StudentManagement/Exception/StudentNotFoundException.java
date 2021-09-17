package com.StudentManagement.Exception;

public class StudentNotFoundException extends RuntimeException
{
    public StudentNotFoundException(String msg)
    {
        super(msg);
    }
}
