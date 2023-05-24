package com.CashCall.HR.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Departments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "department_name")
    private String departmentName;


    /* Constructors */

    /* Getter & Setters */

}

/*
 * Create Relationship between two objects in the Spring Boot Model Using Spring Data JPA
 *
 * Relation Between the Department & Employee
 * 1:M
 * put the PK of the one-side as a FK in the many-side.
 *
 * Many-part will be the Holder of the Relationship.
 * So, the FK will be created from the Many-side (Employee Side).
 *--------
 * OOP-based Framework
 *
 * ----------
 * The Spring Boot require to define a public or protected no-arg constructor in the Entity Class
 * This constructor allows Spring Boot to instantiate the entity when it is retrieved from the database
 * Entity (in Spring Boot): is a Java Class that Represent Table in the DB.
 *
 * */