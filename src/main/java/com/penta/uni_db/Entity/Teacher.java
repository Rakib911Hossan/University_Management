package com.penta.uni_db.Entity;




import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Teacher_Details")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TeacherId")
    private Long teacherId;
    private String name;
    private Long mobile;
    private String email;
    private String address;
    private String rank;
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="courseId(fk)",referencedColumnName = "courseId")
//    private Course course;
}
