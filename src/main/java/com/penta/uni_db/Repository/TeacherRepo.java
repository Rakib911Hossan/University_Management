package com.penta.uni_db.Repository;

import com.penta.uni_db.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
