package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("api/v1/student")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("api/v1/student/id/{id}")
    public Student getStudentsById(@PathVariable("id") Long id) {
        return studentService.getStudentsById(id);
    }


    @GetMapping("api/v1/student/name/{name}")
    public Student getStudentsByName(@PathVariable("name") String name) {
        return studentService.getStudentsByName(name);
    }

    @PostMapping("api/v1/student")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping("api/v1/student/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(id, name, email);
    }
}
