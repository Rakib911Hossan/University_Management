package com.penta.uni_db.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Table(name="Course_Details")
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "courseId")
    private Long courseId;
    private String name;
    private double credit;


//
//    @JsonIgnore
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    @JoinColumn(name = "courseId(fk)", referencedColumnName = "courseId")
//    private List<Teacher> teacher;
//

    @ManyToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<StudentCourse> studentCourse;

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<CourseRegistration> courseRegistration;
}