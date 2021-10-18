package com.example.thiscompany.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCreationRQ {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotEmpty
    private String lastname;

    @Min(value = 18)
    @Max(value = 65)
    private int age;

    @Min(650)
    private float salary;

    private Long officeId;
}
