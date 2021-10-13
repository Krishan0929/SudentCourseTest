package com.StudentManagement.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student_course")
public class studentcourse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "student_id")
    @JoinColumn(name = "student_id")
    private int student_id;

    @Column(name = "course_id")
    @JoinColumn(name = "course_id")
    private int course_id;
}
