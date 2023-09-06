package com.abdullah.educationapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class CourseRequestDto {

    @NotEmpty
    private String name;
    @NotNull
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate startDate;
    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate endDate;

}
