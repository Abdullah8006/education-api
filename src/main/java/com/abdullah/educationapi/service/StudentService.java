package com.abdullah.educationapi.service;

import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
