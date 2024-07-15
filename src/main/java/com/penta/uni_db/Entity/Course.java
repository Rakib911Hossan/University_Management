package com.penta.uni_db.Entity;

import com.penta.uni_db.Entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name="Course_Details")
@Entity

public class Course {
    @Id
    @GeneratedValue
    @Column(name = "CourseId")
    private Long courseId;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="courseId(fk)", referencedColumnName = "courseId")
    private List<Teacher> teacher;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedCourse")
    private Set<Student> studentSet=new HashSet<>();


}

