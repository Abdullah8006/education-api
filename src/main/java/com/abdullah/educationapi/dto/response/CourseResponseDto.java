package com.abdullah.educationapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public class CourseResponseDto {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
