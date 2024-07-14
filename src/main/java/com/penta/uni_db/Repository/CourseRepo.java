package com.penta.uni_db.Repository;
import com.penta.uni_db.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
//    List<Course> findAllByC_Id(long C_ID);
}
