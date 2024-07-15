package com.penta.uni_db.Service;

import com.penta.uni_db.Entity.*;
import com.penta.uni_db.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public class CourseService {

    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void saveCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getCourseDetails(Long courseId) {
//        if (null != C_ID) {
//            return courseRepo.findAllByC_Id(C_ID);
//        } else {
            return courseRepo.findAll();
//        }
    }

    public void deleteProject(Long courseId) {
        courseRepo.deleteById(courseId);
    }
}