package com.example.mogodb1.repo;

import com.example.mogodb1.modles.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentMongRepo extends MongoRepository<Student,String> {
    Optional<Student> findByName(String name);
}
