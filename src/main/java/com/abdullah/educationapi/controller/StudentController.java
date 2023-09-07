package com.abdullah.educationapi.controller;

import com.abdullah.educationapi.dto.request.StudentRequestDto;
import com.abdullah.educationapi.dto.response.StudentResponseDto;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.exception.StudentNotFoundException;
import com.abdullah.educationapi.mapper.StudentMapper;
import com.abdullah.educationapi.service.StudentCourseService;
import com.abdullah.educationapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;
    private final StudentCourseService studentCourseService;


    // Question statement 2-a Save a student details
    @PostMapping
    public ResponseEntity<StudentResponseDto> saveStudents(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        Student student = StudentMapper.dtoToEntity(studentRequestDto);
        student = studentService.save(student);

        StudentResponseDto studentResponseDto = StudentMapper.entityToDto(student);
        return ResponseEntity.ok(studentResponseDto);
    }

    // Question statement 2-d Get all students with selected courses(expecting course ids from front end)
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getStudents(
            @RequestParam(required = false, name = "courseId") List<Long> courseIds) {
        List<Student> byCourseId = studentService.findByCourseId(courseIds);
        List<StudentResponseDto> responseDtoList = byCourseId.stream().map(StudentMapper::entityToDto).toList();

        return ResponseEntity.ok(responseDtoList);
    }

    // Question statement 2-f Delete one student. The mapped student courses will also be automatically deleted
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        Optional<Student> studentOptional = studentService.findById(studentId);
        if(studentOptional.isEmpty()) throw new StudentNotFoundException();

        studentService.deleteStudent(studentOptional.get());
    }
}
