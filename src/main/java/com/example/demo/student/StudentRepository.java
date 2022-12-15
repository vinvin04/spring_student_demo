package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {

    @Query(value = "SELECT * FROM student WHERE name = :name", nativeQuery = true)
    public Student getStudentsByName(String name);
}
