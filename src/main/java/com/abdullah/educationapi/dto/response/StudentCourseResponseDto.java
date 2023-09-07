package com.abdullah.educationapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class StudentCourseResponseDto {

    private Long id;
    private List<CourseResponseDto> courses;
    private StudentResponseDto student;

}
