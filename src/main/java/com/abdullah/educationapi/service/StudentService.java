package com.abdullah.educationapi.service;

import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findByCourseId(List<Long> courseIds) {
        List<Course> courses = courseIds.stream().map(id -> {
            Course course = new Course();
            course.setId(id);

            return course;
        }).collect(Collectors.toList());

        return studentRepository.findByCourses(courses);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
