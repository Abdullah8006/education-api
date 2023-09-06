package com.abdullah.educationapi.service;

import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.entity.StudentCourse;
import com.abdullah.educationapi.repository.StudentCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

}
