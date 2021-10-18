package com.example.thiscompany.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull
    @NotEmpty
    private String lastname;

    @Min(value = 18)
    @Max(value = 65)
    private int age;

    @Min(650)
    private float salary;

    @ManyToOne
    @JoinColumn(name = "id_office")
    Office office;
}


