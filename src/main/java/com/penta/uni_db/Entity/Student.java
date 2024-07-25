package com.penta.uni_db.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
    private String address;
    private Long mobile;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CourseRegistration> courseRegistration;
}

