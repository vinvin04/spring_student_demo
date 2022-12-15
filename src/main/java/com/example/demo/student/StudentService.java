package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        Student s1 = new Student(
//                "sdfss",
//                "sfdfs@email.com",
//                LocalDate.of(2000, Month.JANUARY,05),
//                23
//        );
//        studentRepository.saveAndFlush(s1);
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        System.out.println(student);
        studentRepository.save(student);
    }

    public Student getStudentsById(Long id) {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isPresent())
            return (Student) result.get();
        else
            return null;
    }

    public Student getStudentsByName(String name) {
        Student result = studentRepository.getStudentsByName(name);
        return result;
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                " Student with id:" + studentId + " not found") );

        if(name != null && name.length() > 0 &&
            !name.equals(student.getName())) {
            System.out.println("name updated");
            student.setName(name);
        }

        if(email != null && email.length() > 0 &&
                !email.equals(student.getEmail())) {
            student.setEmail(email);
        }
    }
}
