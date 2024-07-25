package com.penta.uni_db.Repository;

import com.penta.uni_db.Entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, Long> {
}
