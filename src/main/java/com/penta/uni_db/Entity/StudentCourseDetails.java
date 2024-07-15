package com.penta.uni_db.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="Student_Course_Details")
@Entity
public class StudentCourseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    @JoinColumn(name = "student_name",referencedColumnName = "studentName")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;



}






