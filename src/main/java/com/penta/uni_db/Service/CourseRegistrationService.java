package com.penta.uni_db.Service;


import com.penta.uni_db.Entity.CourseRegistration;
import com.penta.uni_db.Repository.CourseRepo;
import com.penta.uni_db.Repository.CourseRegistrationRepo;
import com.penta.uni_db.Repository.StudentRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CourseRegistrationService {
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final CourseRegistrationRepo courseRegistrationRepo;

    public CourseRegistrationService(StudentRepo studentRepo, CourseRepo courseRepo, CourseRegistrationRepo courseRegistrationRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.courseRegistrationRepo = courseRegistrationRepo;
    }

    public void saveCourseRegistration(CourseRegistration courseRegistration){
        courseRegistrationRepo.save(courseRegistration);
    }

    public List<CourseRegistration> getCourseRegistration(){
        return courseRegistrationRepo.findAll();
    }

    @Cacheable(value = "Course_Registration_Details",key = "#registrationId")
    public Optional<CourseRegistration> getCourseRegistrationById(@PathVariable(required = true)Long registrationId){
        return courseRegistrationRepo.findById(registrationId);
    }

    public void deleteCourseRegistration(Long registrationId){
        courseRegistrationRepo.deleteById(registrationId);
    }
}
