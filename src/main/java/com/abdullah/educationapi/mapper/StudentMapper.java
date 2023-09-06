package com.abdullah.educationapi.mapper;

import com.abdullah.educationapi.dto.request.StudentRequestDto;
import com.abdullah.educationapi.dto.response.StudentResponseDto;
import com.abdullah.educationapi.entity.Student;

/**
 * Not very useful to have Mappers, ReqDTOs and ResDTOs for this use case but when the projects gets huge this really helps.
 */
public class StudentMapper {

    public static Student dtoToEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setAddress(studentRequestDto.getAddress());
        student.setEmail(studentRequestDto.getEmail());
        student.setTelephone(studentRequestDto.getTelephone());
        student.setFullName(studentRequestDto.getFullName());

        return student;
    }

    public static StudentResponseDto entityToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setAddress(student.getAddress());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setTelephone(student.getTelephone());
        studentResponseDto.setFullName(student.getFullName());

        return studentResponseDto;
    }
}
