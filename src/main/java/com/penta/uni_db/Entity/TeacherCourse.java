package com.penta.uni_db.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TeacherCourseDetails")
public class TeacherCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacherId")
    private Long teacherId;
    private String name;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="courseId(fk)",referencedColumnName = "courseId")
    private CourseRegistration courseRegistration;

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<StudentCourse> studentCourse;
//
}
