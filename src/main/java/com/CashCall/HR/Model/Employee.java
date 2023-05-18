package com.CashCall.HR.Model;


import jakarta.persistence.*; // JPA

import javax.swing.plaf.basic.DefaultMenuLayout;
import java.util.Date;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name ")
    private String lastName;
    @Column(name = "salary")
    private Double Salary;
    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNum;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "commission_pct")
    private Double commPct;
    @Column(name = "manager_id")
    private Long mangerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id ")
    private Department department;


    /* Constructors */
    public Employee() {
    }


    public Employee(long id, String firstName, String lastName, Double salary, String address, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Salary = salary;
        this.address = address;
        this.department = department;
    }


    /* Getter & Setters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
