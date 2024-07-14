package com.penta.uni_db.Entity;

import com.penta.uni_db.Entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name="Course")
@Entity

public class Course {
    @Id
    @GeneratedValue
    private Long C_ID;
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="C_ID(fk)", referencedColumnName = "C_ID")
    private List<Teacher> teacher;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedCourse")
    private Set<Student> studentSet=new HashSet<>();


}

