package com.abdullah.educationapi.controller;

import com.abdullah.educationapi.dto.request.StudentRequestDto;
import com.abdullah.educationapi.dto.response.StudentResponseDto;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.mapper.StudentMapper;
import com.abdullah.educationapi.repository.StudentRepository;
import com.abdullah.educationapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> saveStudents(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        Student student = StudentMapper.dtoToEntity(studentRequestDto);
        student = studentService.save(student);

        StudentResponseDto studentResponseDto = StudentMapper.entityToDto(student);
        return ResponseEntity.ok(studentResponseDto);
    }
}
