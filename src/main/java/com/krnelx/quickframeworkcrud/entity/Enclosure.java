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
@Table(name = "enclosure")
public class Enclosure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String type;

    @Min(0)
    private int capacity;
}