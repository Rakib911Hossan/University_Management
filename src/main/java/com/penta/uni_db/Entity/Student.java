package com.penta.uni_db.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@Table(name="Student_Details")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private Long studentId;
    @Column(name = "studentName")
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(name = "Student_Course",
    joinColumns = @JoinColumn(name = "studentId")
    ,
    inverseJoinColumns =@JoinColumn(name = "courseId")
    )
    private Set<Course> assignedCourse=new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentCourseDetails> studentCourseDetails;
}

