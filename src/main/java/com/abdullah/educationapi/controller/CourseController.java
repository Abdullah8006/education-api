package com.abdullah.educationapi.controller;

import com.abdullah.educationapi.dto.request.CoursePatchRequestDto;
import com.abdullah.educationapi.dto.request.CourseRequestDto;
import com.abdullah.educationapi.dto.request.StudentRequestDto;
import com.abdullah.educationapi.dto.response.CourseResponseDto;
import com.abdullah.educationapi.dto.response.StudentResponseDto;
import com.abdullah.educationapi.entity.Course;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.exception.CourseNotFoundException;
import com.abdullah.educationapi.exception.PathVariableNotFoundException;
import com.abdullah.educationapi.mapper.CourseMapper;
import com.abdullah.educationapi.mapper.StudentMapper;
import com.abdullah.educationapi.service.CourseService;
import com.abdullah.educationapi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Validated
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDto> saveCourse(@Valid @RequestBody CourseRequestDto courseRequestDto) {
        Course course = CourseMapper.dtoToEntity(courseRequestDto);
        course = courseService.save(course);

        CourseResponseDto courseResponseDto = CourseMapper.entityToDto(course);
        return ResponseEntity.ok(courseResponseDto);
    }

    // Pagination not implemented due to time constraint
    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getCourse(@RequestParam(required = false) Long id) {
        List<Course> courses = new ArrayList<>();

        if (id != null) {
            Optional<Course> course = courseService.findById(id);

            if (course.isEmpty()) throw new CourseNotFoundException();
            courses.add(course.get());
        } else {
            courses = courseService.findAll();
        }

        List<CourseResponseDto> courseResponse = courses.stream().map(CourseMapper::entityToDto).toList();
        return ResponseEntity.ok(courseResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Long id, @RequestBody CoursePatchRequestDto coursePatchRequestDto) {
        if(id == null) throw new PathVariableNotFoundException();

        Optional<Course> byId = courseService.findById(id);
        if(byId.isEmpty()) throw new CourseNotFoundException();

        Course course = byId.get();
        course.setName(coursePatchRequestDto.getName());

        course = courseService.save(course);
        CourseResponseDto courseResponseDto = CourseMapper.entityToDto(course);
        return ResponseEntity.ok(courseResponseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        if(id == null) throw new PathVariableNotFoundException();

        Optional<Course> byId = courseService.findById(id);
        if(byId.isEmpty()) throw new CourseNotFoundException();

        courseService.delete(byId.get());
    }
}
