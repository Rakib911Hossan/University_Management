package com.penta.uni_db.Entity;

import com.penta.uni_db.Entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name="courseId(fk)")
    private Course course;
}
