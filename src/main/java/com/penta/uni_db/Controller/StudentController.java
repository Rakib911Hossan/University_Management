package com.penta.uni_db.Controller;
import com.penta.uni_db.Entity.Student;
import com.penta.uni_db.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController{

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = {"/getStudent", "/{S_ID}"})
    public List<Student> getStudent(@PathVariable(required = false) Long S_ID) {
        return studentService.getStudentDetails(S_ID);
    }

    @DeleteMapping("delete/{S_ID}")
    public ResponseEntity removeStudent(@PathVariable Long S_ID){
        studentService.deleteStudent(S_ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{S_ID}/course/{C_ID}")
    public Student assignCourseToStudent(
            @PathVariable Long S_ID,
            @PathVariable Long C_ID
    ){
        return studentService.assignCourseToStudent(S_ID, C_ID);
    }




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
