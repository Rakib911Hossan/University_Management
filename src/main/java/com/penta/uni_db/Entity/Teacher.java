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
@Table(name="Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="T_ID")
    private Long T_ID;
    private String name;

    @ManyToOne
    @JoinColumn(name="C_ID(fk)")
    private Course course;
}
