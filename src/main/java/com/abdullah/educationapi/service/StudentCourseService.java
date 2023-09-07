package com.abdullah.educationapi.service;

import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.entity.StudentCourse;
import com.abdullah.educationapi.repository.StudentCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public List<StudentCourse> findAll() {
        return studentCourseRepository.findAll();
    }

    public List<StudentCourse> findByStudentAndCourseId(Long studentId, Long courseId) {
        return studentCourseRepository.findByStudentIdAndCourseId(studentId, courseId);
    }

    public List<StudentCourse> updateNewStudentCourses(List<StudentCourse> courses) {
        return studentCourseRepository.saveAll(courses);
    }

    public List<StudentCourse> findAllByStudent(Student student) {
        return studentCourseRepository.findAllByStudent(student);
    }

    public void deleteAllByStudent(Student student) {
        List<StudentCourse> studentCourses = findAllByStudent(student);
        studentCourseRepository.deleteAll(studentCourses);
    }
}
