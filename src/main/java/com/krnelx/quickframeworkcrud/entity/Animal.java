package com.krnelx.quickframeworkcrud.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.*;

import lombok.Data;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String species;

    @Min(0)
    private int age;

    @NotNull
    @Column(name = "enclosure_id")
    private int enclosureId;
}
