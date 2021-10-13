package com.StudentManagement.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class course
{
    @Id
    @Column(name = "course_id")
    private int id;

    private String name;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<student> students;
}
