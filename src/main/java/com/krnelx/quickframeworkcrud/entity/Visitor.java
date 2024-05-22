package com.krnelx.quickframeworkcrud.entity;

import jakarta.validation.constraints.Min;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;

import lombok.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    private String name;

    @Min(0)
    private int age;
}
