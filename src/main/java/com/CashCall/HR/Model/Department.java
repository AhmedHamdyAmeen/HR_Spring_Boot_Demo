package com.CashCall.HR.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "department_name")
    private String departmentName;


    /* Constructors */
    protected Department() {
        // The Spring Boot require to define a public or protected no-arg constructor in the Entity Class
        // This constructor allows Spring Boot to instantiate the entity when it is retrieved from the database

        // Entity (in Spring Boot): is a Java Class that Represent Table in the DB.
    }

    public Department(long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }


    /* Getter & Setters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


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
 *
 *
 * */