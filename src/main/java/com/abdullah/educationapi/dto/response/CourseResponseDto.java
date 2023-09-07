package com.abdullah.educationapi.dto.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
