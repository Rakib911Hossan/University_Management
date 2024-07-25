package com.penta.uni_db.Repository;

import com.penta.uni_db.Entity.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepo extends JpaRepository<CourseRegistration, Long> {
}
