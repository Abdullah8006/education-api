package com.abdullah.educationapi.controller;

import com.abdullah.educationapi.dto.request.StudentCourseRequestDto;
import com.abdullah.educationapi.dto.request.StudentCourseUpdateRequestDto;
import com.abdullah.educationapi.dto.response.StudentCourseResponseDto;
import com.abdullah.educationapi.dto.response.StudentResponseDto;
import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.entity.StudentCourse;
import com.abdullah.educationapi.exception.CourseNotFoundException;
import com.abdullah.educationapi.exception.StudentNotFoundException;
import com.abdullah.educationapi.mapper.StudentCourseMapper;
import com.abdullah.educationapi.service.CourseService;
import com.abdullah.educationapi.service.StudentCourseService;
import com.abdullah.educationapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students/{studentId}/courses")
@RequiredArgsConstructor
@Validated
public class StudentCourseController {

    private final StudentCourseService studentCourseService;
    private final StudentService studentService;
    private final CourseService courseService;

    // Question statement 2-c Allocate student with a selected course
    @PostMapping
    public ResponseEntity<StudentCourseResponseDto> saveStudentsCourse(@PathVariable Long studentId, @Valid @RequestBody StudentCourseRequestDto studentCourseRequestDto) {
        Optional<Student> studentOptional = studentService.findById(studentId);
        Optional<Course> courseOptional = courseService.findById(studentCourseRequestDto.getCourseId());

        if (studentOptional.isEmpty()) throw new StudentNotFoundException();
        if (courseOptional.isEmpty()) throw new CourseNotFoundException();

        StudentCourse studentCourse = StudentCourse.builder().course(courseOptional.get()).student(studentOptional.get()).build();
        studentCourse = studentCourseService.saveStudentCourse(studentCourse);

        return ResponseEntity.ok(StudentCourseMapper.entityToDto(studentCourse));
    }

    // Question statement 2-e Update courses for one student. Expecting new course ids in the request body
    // Because of time constraints I not able to return a populated response DTO
    @PatchMapping
    public ResponseEntity<List<StudentCourseResponseDto>> updateStudentsCourse(
            @PathVariable Long studentId,
            @Valid @RequestBody StudentCourseUpdateRequestDto studentCourseUpdateRequestDto) {
        Optional<Student> studentOptional = studentService.findById(studentId);

        if (studentOptional.isEmpty()) throw new StudentNotFoundException();
        Student student = studentOptional.get();

        // Update new courses
        List<StudentCourse> studentCourses = studentCourseUpdateRequestDto.getNewCourseIds().stream().map(id -> {
            return StudentCourse.builder()
                    .student(student)
                    .course(Course.builder()
                            .id(id)
                            .build()
                    ).build();
        }).toList();

        student.getCourses().clear();
        student.getCourses().addAll(studentCourses);
        studentService.save(student);

        List<StudentCourseResponseDto> courseResponseDtoList = studentCourses.stream().map(StudentCourseMapper::entityToDto).toList();
        return ResponseEntity.ok(courseResponseDtoList);
    }

}
