package com.penta.uni_db.Controller;

import com.penta.uni_db.Entity.*;
import com.penta.uni_db.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teacher")
@Component
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/saveTeacher")
    public ResponseEntity<Teacher> createCourse(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getTeacher"})
    public List<Teacher> getTeacher(@PathVariable(required = false) Long teacherId) {
        return teacherService.getTeacherDetails(teacherId);
    }


    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity <Teacher>removeTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




