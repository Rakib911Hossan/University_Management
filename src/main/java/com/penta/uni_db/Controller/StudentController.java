package com.penta.uni_db.Controller;
import com.penta.uni_db.Entity.Student;
import com.penta.uni_db.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Component
public class StudentController{

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/getStudent" )
    public List<Student> getStudent() {
        return studentService.getStudentDetails();
    }

    @GetMapping(value = "/getStudent/{studentId}" )
    public Optional<Student> getStudentById(@PathVariable(required = true) Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<Student> removeStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping("/{studentId}/course/{courseId}")
//    public Student assignCourseToStudent(
//            @PathVariable Long studentId,
//            @PathVariable Long courseId
//    ){
//        return studentService.assignCourseToStudent(studentId, courseId);
//    }
//



//
//    @GetMapping(value = {"/getEmployees", "/{empId}"})
//    public List<Employee> getEmployee(@PathVariable(required = false) Long empId) {
//        return employeeService.getEmployeeDetails(empId);
//    }
//
//    @DeleteMapping("delete/{empId}")
//    public ResponseEntity removeEmployee(@PathVariable Long empId){
//        employeeService.deleteEmployee(empId);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @PutMapping("/{empId}/project/{projectId}")
//    public Employee assignProjectToEmployee(
//            @PathVariable Long empId,
//            @PathVariable Long projectId
//    ){
//        return employeeService.assignProjectToEmployee(empId, projectId);
//    }
//}




}
