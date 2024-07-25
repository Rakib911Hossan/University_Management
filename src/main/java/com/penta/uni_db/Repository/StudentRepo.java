package com.penta.uni_db.Repository;

import com.penta.uni_db.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
//    List<Student> findAllByS_ID(Long S_ID);
}

