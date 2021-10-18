package com.example.thiscompany.request;

import com.example.thiscompany.model.OfficeLocation;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeReturnRQ {

    private Long id;

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

    private OfficeLocation officeLocation;
}