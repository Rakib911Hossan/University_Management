package com.penta.uni_db.Repository;

import com.penta.uni_db.Entity.StudentCourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseDetailsRepo extends JpaRepository<StudentCourseDetails, Long> {
}
