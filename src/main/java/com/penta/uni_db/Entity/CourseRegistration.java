package com.penta.uni_db.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="CourseRegistrationDetails")
@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrationId")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    Student student;


    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    Course course;



}






