package com.penta.uni_db.Service;

import com.penta.uni_db.Entity.Student;
import com.penta.uni_db.Entity.Course;
import com.penta.uni_db.Repository.StudentRepo;
import com.penta.uni_db.Repository.CourseRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Component
public class StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }


        public List<Student> getStudentDetails (){
//            if (null != S_ID) {
//                return studentRepo.findAllByS_ID(S_ID);
//            } else {
                return studentRepo.findAll();
//            }
        }

    public Optional<Student> getStudentById (Long studentId){
//            if (null != S_ID) {
//                return studentRepo.findAllByS_ID(S_ID);
//            } else {
        return studentRepo.findById(studentId);
//            }
    }
//
//        public Student assignCourseToStudent (Long studentId, Long courseId){
//            Set<Course> courseSet = null;
//            Student student = studentRepo.findById(studentId).get();
//            Course course = courseRepo.findById(courseId).get();
//            courseSet = student.getAssignedCourse();
//            courseSet.add(course);
//            student.setAssignedCourse(courseSet);
//            return studentRepo.save(student);
//        }
//


        public void deleteStudent(Long studentId){
            studentRepo.deleteById(studentId);
        }
//
//        @PostMapping("/add")
//    public Student addStudentWithCourse(@RequestBody Student student) {
//        return studentRepo.save(student);
//    }


//
//    @GetMapping
//    public List<Student> findAllStudent() {
//        return studentRepo.findAll();
//    }
//
//    @GetMapping("/{S_ID}")
//    public Student findStudent(@PathVariable Long S_ID) {
//        return studentRepo.findById(S_ID).orElse(null);
//    }
//
//    @GetMapping("/{C_ID}")
//    public Course findCourse(@PathVariable Long C_ID) {
//        return courseRepo.findById(C_ID).orElse(null);
//    }
}




