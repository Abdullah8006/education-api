package com.abdullah.educationapi.mapper;

import com.abdullah.educationapi.dto.request.StudentRequestDto;
import com.abdullah.educationapi.dto.response.StudentCourseResponseDto;
import com.abdullah.educationapi.dto.response.StudentResponseDto;
import com.abdullah.educationapi.entity.Student;
import com.abdullah.educationapi.entity.StudentCourse;

/**
 * Not very useful to have Mappers, ReqDTOs and ResDTOs for this use case but when the projects gets huge this really helps.
 */
public class StudentCourseMapper {

    public static StudentCourse dtoToEntity(StudentRequestDto studentRequestDto) {

        return null;
    }

    public static StudentCourseResponseDto entityToDto(StudentCourse studentCourse) {
        return StudentCourseResponseDto.builder()
                .course(CourseMapper.entityToDto(studentCourse.getCourse()))
                .student(StudentMapper.entityToDto(studentCourse.getStudent()))
                .id(studentCourse.getId())
                .build();
    }
}
