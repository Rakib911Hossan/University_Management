package com.penta.uni_db.Controller;


import com.penta.uni_db.Entity.CourseRegistration;
import com.penta.uni_db.Service.CourseRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("CourseRegistration")
@Component
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    public CourseRegistrationController(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

    @PostMapping("/saveCourseRegistration")
    public ResponseEntity<CourseRegistration> saveCourseRegistration(@RequestBody CourseRegistration courseRegistration){
        courseRegistrationService.saveCourseRegistration(courseRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getCourseRegistration")
    public List<CourseRegistration> getCourseRegistration(){
        return courseRegistrationService.getCourseRegistration();
    }

    @GetMapping("/getCourseRegistration/{registrationId}")
    public Optional<CourseRegistration> getCourseRegistrationById(@PathVariable(required = true) Long registrationId){
        return courseRegistrationService.getCourseRegistrationById(registrationId);
    }

    @DeleteMapping("delete/{registrationId}")
    public ResponseEntity<CourseRegistration> removeCourseRegistrationById(@PathVariable Long registrationId){
        courseRegistrationService.deleteCourseRegistration(registrationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
