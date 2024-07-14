package com.penta.uni_db.Controller;

import com.penta.uni_db.Entity.Course;
import com.penta.uni_db.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")


public class CourseController {

        @Autowired
        private CourseService courseService;

        @PostMapping("/save")
        public ResponseEntity<Course> createCourse(@RequestBody Course course) {
            courseService.saveCourse(course);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @GetMapping(value = {"/getCourse"})
        public List<Course> getCourse(@PathVariable(required = false) Long C_ID) {
            return courseService.getCourseDetails(C_ID);
        }

        @DeleteMapping("/delete/{C_ID}")
        public ResponseEntity <Course>removeCourse(@PathVariable Long C_ID) {
            courseService.deleteProject(C_ID);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

