package com.abdullah.educationapi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StudentRequestDto {

    @NotEmpty
    private String fullName;
    @Email
    private String email;
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$")
    private String telephone;
    @NotEmpty
    private String address;

}
