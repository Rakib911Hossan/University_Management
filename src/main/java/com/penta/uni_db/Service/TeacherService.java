package com.penta.uni_db.Service;

import com.penta.uni_db.Entity.*;
import com.penta.uni_db.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public void saveTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public List<Teacher> getTeacherDetails(Long T_ID) {
//        if (null != C_ID) {
//            return courseRepo.findAllByC_Id(C_ID);
//        } else {
        return teacherRepo.findAll();
//        }
    }

    public void deleteTeacher(Long T_ID) {
        teacherRepo.deleteById(T_ID);
    }
}




