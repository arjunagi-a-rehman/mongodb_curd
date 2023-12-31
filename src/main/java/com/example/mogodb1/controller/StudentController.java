package com.example.mogodb1.controller;

import com.example.mogodb1.modles.Student;
import com.example.mogodb1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok("added");
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/student")
    public Student findByName(@RequestParam String name){
        return studentService.findByName(name);
    }
    @PutMapping("/student")
    public ResponseEntity<String> updateRecord(@RequestBody Student student){
        studentService.updateRecord(student);
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        studentService.deleteById(id);
        return ResponseEntity.ok("deleted");

    }
}
