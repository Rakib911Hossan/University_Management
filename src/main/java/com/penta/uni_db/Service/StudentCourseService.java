package com.penta.uni_db.Service;


import com.penta.uni_db.Entity.StudentCourse;
import com.penta.uni_db.Repository.StudentCourseRepo;
import com.penta.uni_db.Repository.TeacherCourseRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentCourseService {
    private final StudentCourseRepo studentCourseRepo;
    private final TeacherCourseRepo teacherCourseRepo;

    public StudentCourseService(StudentCourseRepo studentCourseRepo, TeacherCourseRepo teacherCourseRepo) {
        this.studentCourseRepo = studentCourseRepo;
        this.teacherCourseRepo = teacherCourseRepo;
    }

    public List<StudentCourse> getStudentCourse(){
        return studentCourseRepo.findAll();
    }
}
