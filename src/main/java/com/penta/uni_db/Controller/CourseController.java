package com.penta.uni_db.Controller;

import com.penta.uni_db.Entity.Course;
import com.penta.uni_db.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")

@Component
public class CourseController {

        private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/saveCourse")
        public ResponseEntity<Course> createCourse(@RequestBody Course course) {
            courseService.saveCourse(course);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @GetMapping(value = {"/getCourse"})

        public List<Course> getCourse(@PathVariable(required = false) Long courseId) {
            return courseService.getCourseDetails(courseId);
        }

        @GetMapping("getCourse/{courseId}")
        public Optional<Course> getCourseById(@PathVariable(required = true)Long courseId){
        return courseService.getCourseById(courseId);
        }

        @DeleteMapping("/delete/{courseId}")
        public ResponseEntity<Course> removeCourse(@PathVariable Long courseId) {
            courseService.deleteProject(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

