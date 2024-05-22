package com.krnelx.quickframeworkcrud.entity;

import jakarta.validation.constraints.PositiveOrZero;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;

import lombok.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String position;

    @PositiveOrZero
    private double salary;
}