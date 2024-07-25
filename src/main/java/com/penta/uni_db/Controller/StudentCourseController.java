package com.penta.uni_db.Controller;


import com.penta.uni_db.Entity.StudentCourse;
import com.penta.uni_db.Service.StudentCourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StudentCourse")
public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/getStudentCourse")
    public List<StudentCourse>getStudentCourse(){
        return studentCourseService.getStudentCourse();
    }
}
