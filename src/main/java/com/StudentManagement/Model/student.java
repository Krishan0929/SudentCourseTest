package com.StudentManagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class student
{
    @Id
    @Column(name = "student_id")
    private int id;

    private String first_name;

    private String last_name;

    private String DOB;

    private String gender;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "student_course",
               joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "student_id")},
             inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "course_id")})
    private List<course> courses;

    /*@OneToMany(cascade = CascadeType.ALL)
    private List<studentcourse> studentcourses;*/

}
