package com.penta.uni_db.Entity;




import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Teacher_Details")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TeacherId")
    private Long teacherId;
    private String name;

    @ManyToOne
    @JoinColumn(name="courseId(fk)",referencedColumnName = "courseId")
    private Course course;
}
