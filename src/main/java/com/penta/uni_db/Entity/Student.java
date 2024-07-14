package com.penta.uni_db.Entity;
import com.penta.uni_db.Entity.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@Table(name="Student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long S_ID;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(name = "StudentCourse",
    joinColumns = @JoinColumn(name = "S_ID")
    ,
    inverseJoinColumns =@JoinColumn(name = "C_ID")
    )
    private Set<Course> assignedCourse=new HashSet<>();
}

