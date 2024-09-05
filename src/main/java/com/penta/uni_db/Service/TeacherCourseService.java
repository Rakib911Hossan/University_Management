package com.penta.uni_db.Service;


import com.penta.uni_db.Entity.Course;
import com.penta.uni_db.Entity.TeacherCourse;
import com.penta.uni_db.Repository.CourseRepo;
import com.penta.uni_db.Repository.TeacherCourseRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class TeacherCourseService {
    private final TeacherCourseRepo teacherCourseRepo;
    private final CourseRepo courseRepo;

    public TeacherCourseService(TeacherCourseRepo teacherCourseRepo, CourseRepo courseRepo) {
        this.teacherCourseRepo = teacherCourseRepo;
        this.courseRepo = courseRepo;
    }

    public void saveTeacherCourse(TeacherCourse teacherCourse){
        teacherCourseRepo.save(teacherCourse);
    }

    public List<TeacherCourse> getTeacherCourse(){
        return teacherCourseRepo.findAll();
    }

    @Cacheable(value = "Teacher_Course_Details",key = "#teacherId")
    public Optional<TeacherCourse> getTeacherCourseById(Long teacherId){
        return teacherCourseRepo.findById(teacherId);
    }


    public void deleteTeacherCourse(Long teacherId){
        teacherCourseRepo.deleteById(teacherId);
    }

}
