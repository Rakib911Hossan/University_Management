package com.penta.uni_db.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name="CourseRegistrationDetails")
@Entity
public class CourseRegistration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private Long courseId;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RegisteredStudents",
            joinColumns ={ @JoinColumn(name = "courseId",referencedColumnName = "courseId")}
            ,
            inverseJoinColumns =@JoinColumn(name = "studentId",referencedColumnName = "studentId")
    )
    private Set<Student> student=new HashSet<>();



}






