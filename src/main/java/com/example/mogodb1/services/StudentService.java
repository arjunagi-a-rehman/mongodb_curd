package com.example.mogodb1.services;

import com.example.mogodb1.modles.Student;
import com.example.mogodb1.repo.IStudentMongRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    IStudentMongRepo studentMongRepo;
    NextSequenceService nextSequenceService;
    public void addStudent(Student student){
        student.setId(String.valueOf(nextSequenceService.getNextSequence("customSequences")));
        studentMongRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentMongRepo.findAll();
    }
    public Student findByName(String name){
        Student student=studentMongRepo.findByName(name).orElseThrow();
        return student;
    }

    public void updateRecord(Student student) {
        Student student1=studentMongRepo.findById(student.getId()).orElseThrow();
        studentMongRepo.save(student);
    }

    public void deleteById(String id) {
        studentMongRepo.deleteById(id);
    }
}
