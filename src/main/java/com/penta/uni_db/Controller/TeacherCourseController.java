package com.penta.uni_db.Controller;


import com.penta.uni_db.Entity.TeacherCourse;
import com.penta.uni_db.Service.TeacherCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TeacherCourse")
@Component
public class TeacherCourseController {
    private final TeacherCourseService teacherCourseService;

    public TeacherCourseController(TeacherCourseService teacherCourseService) {
        this.teacherCourseService = teacherCourseService;
    }

    @PostMapping("/saveTeacherCourse")
    public ResponseEntity<TeacherCourse> saveTeacherCourse(@RequestBody TeacherCourse teacherCourse){
        teacherCourseService.saveTeacherCourse(teacherCourse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getTeacherCourse")
    public List<TeacherCourse> getTeacherCourse(){
    return teacherCourseService.getTeacherCourse();
    }

    @GetMapping("/getTeacherCourse/{teacherId}")
    public Optional<TeacherCourse> getTeacherCourseById(@PathVariable(required = true) Long teacherId){
       return teacherCourseService.getTeacherCourseById(teacherId);
    }

    @DeleteMapping("delete/{teacherId}")
    public ResponseEntity<TeacherCourse> removeTeacherCourse(@PathVariable Long teacherId){
        teacherCourseService.deleteTeacherCourse(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
