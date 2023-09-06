package com.abdullah.educationapi.mapper;

import com.abdullah.educationapi.dto.request.CourseRequestDto;
import com.abdullah.educationapi.dto.response.CourseResponseDto;
import com.abdullah.educationapi.entity.Course;

/**
 * Not very useful to have Mappers, ReqDTOs and ResDTOs for this use case but when the projects gets huge this really helps.
 */
public class CourseMapper {

    public static Course dtoToEntity(CourseRequestDto courseRequestDto) {
        return Course.builder()
                .name(courseRequestDto.getName())
                .startDate(courseRequestDto.getStartDate())
                .endDate(courseRequestDto.getEndDate())
                .build();
    }

    public static CourseResponseDto entityToDto(Course course) {
        return CourseResponseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .build();
    }
}
