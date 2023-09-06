package com.abdullah.educationapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class StudentCourseResponseDto {

    private Long id;
    private CourseResponseDto course;
    private StudentResponseDto student;

}
