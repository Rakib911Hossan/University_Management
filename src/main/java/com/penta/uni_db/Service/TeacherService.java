package com.penta.uni_db.Service;

import com.penta.uni_db.Entity.*;
import com.penta.uni_db.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void saveTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public List<Teacher> getTeacherDetails() {
//        if (null != C_ID) {
//            return courseRepo.findAllByC_Id(C_ID);
//        } else {
        return teacherRepo.findAll();
//        }
    }
    @Cacheable(value = "Teacher_Details",key = "#taecherId")
    public Optional<Teacher> getTeacherByID(Long teacherId) {
//        if (null != C_ID) {
//            return courseRepo.findAllByC_Id(C_ID);
//        } else {
        return teacherRepo.findById(teacherId);
//        }
    }


    public void deleteTeacher(Long teacherId) {
        teacherRepo.deleteById(teacherId);
    }
}




