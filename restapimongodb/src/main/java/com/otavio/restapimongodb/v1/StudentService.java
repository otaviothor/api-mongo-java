package com.otavio.restapimongodb.v1;

import java.util.List;

import com.otavio.restapimongodb.Student;
import com.otavio.restapimongodb.StudentRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
}
