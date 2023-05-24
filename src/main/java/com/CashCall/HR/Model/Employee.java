package com.CashCall.HR.Model;


import jakarta.persistence.*; // JPA
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name")
    @NotEmpty(message = "First name must not be empty")
    @NotNull
    private String firstName;

    @Column(name = "last_name ")
    private String lastName;

    @Column(name = "salary")
    @NotNull(message = "Salary must Entered")
    private Double Salary;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", unique = true, length = 11)
    @Size(min = 10, max = 11, message = "Min length is 10 & Max length is 11 Number")
    private String phoneNum;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "commission_pct")
    private Double commPct;

    @Column(name = "email", nullable = false)
    @Email(message = "You should to Enter a valid email address")
    private String email;

    @Column(name = "manager_id")
    private Long mangerId;

    //    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne()
    @JoinColumn(name = "department_id ")
    private Department department;


    /* Constructors */

    /* Getter & Setters */

}
