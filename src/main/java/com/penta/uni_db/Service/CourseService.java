package com.penta.uni_db.Service;

import com.penta.uni_db.Entity.*;
import com.penta.uni_db.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public void saveCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getCourseDetails(Long C_ID) {
//        if (null != C_ID) {
//            return courseRepo.findAllByC_Id(C_ID);
//        } else {
            return courseRepo.findAll();
//        }
    }

    public void deleteProject(Long C_ID) {
        courseRepo.deleteById(C_ID);
    }
}