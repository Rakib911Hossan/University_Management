package com.penta.uni_db.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Table(name="StudentCourseDetails")
@Entity
public class StudentCourse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private Long studentId;
    @Column(name = "studentName")
    private String name;

//    @JsonIgnore
    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Course",
            joinColumns ={ @JoinColumn(name = "studentId",referencedColumnName = "studentId")}
            ,
            inverseJoinColumns =@JoinColumn(name = "courseId",referencedColumnName = "courseId")
    )
    private Set<Course> course;
//    @JsonIgnore
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private Set<CourseRegistration> courseRegistration;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "teacherId(fk)",referencedColumnName = "teacherId")
//    private TeacherCourse teacherCourse;


}

