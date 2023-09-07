package com.abdullah.educationapi.config;

import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.entity.StudentCourse;
import com.abdullah.educationapi.repository.CourseRepository;
import com.abdullah.educationapi.repository.StudentCourseRepository;
import com.abdullah.educationapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student s1 = new Student(1L, "Abdullah Khan 1", "a@b.com", "6798989898", "Jumera", Collections.emptyList());
        Student s2 = new Student(2L, "Talha Khan 2", "a@b.com", "8798989898", "Dubai", Collections.emptyList());
        Student s3 = new Student(3L, "Zubair Khan 3", "a@b.com", "1998989898", "UAR", Collections.emptyList());
        Student s4 = new Student(4L, "Hashim Khan 4", "a@b.com", "1198989898", "Kuwait", Collections.emptyList());

        studentRepository.saveAll(List.of(s1, s2, s3, s4));

        Course course1 = new Course(1L, "Hafiz Course", LocalDate.now(), LocalDate.now().plusMonths(24));
        Course course2 = new Course(2L, "Pilot Course", LocalDate.now(), LocalDate.now().plusMonths(36));
        Course course3 = new Course(3L, "Agriculture Course", LocalDate.now(), LocalDate.now().plusMonths(12));

        courseRepository.saveAll(List.of(course1, course2, course3));

        StudentCourse studentCourse1 = new StudentCourse(1L, s1, course1);
        StudentCourse studentCourse2 = new StudentCourse(2L, s1, course2);
        StudentCourse studentCourse3 = new StudentCourse(3L, s2, course2);
        StudentCourse studentCourse4 = new StudentCourse(4L, s3, course2);
        StudentCourse studentCourse5 = new StudentCourse(5L, s4, course3);

        studentCourseRepository.saveAll(List.of(studentCourse1, studentCourse2, studentCourse3, studentCourse4, studentCourse5));
    }
}
