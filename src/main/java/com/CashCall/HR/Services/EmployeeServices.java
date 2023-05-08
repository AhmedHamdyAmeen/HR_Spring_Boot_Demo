package com.CashCall.HR.Services;

import com.CashCall.HR.Model.Employee;
import com.CashCall.HR.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    /* Dependencies */

    @Autowired
    private EmployeeRepo employeeRepo;


    /* DB Methods */

    // a => Retrieving Methods:
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }


    public Employee findEmployeeByID(Long id) {
        return employeeRepo.findById(id).orElseThrow(null);
    }

    public List<Employee> findEmployeeByFirstName(String firstName) {
        return employeeRepo.findByFirstName(firstName);
    }

    public List<Employee> employeeSearch(String firstName, String lastName) {
        return employeeRepo.empSearch(firstName, lastName);
    }

    ;

    // b => Inserting Methods:
    public void addNewEmp(Employee newEmp) {
        employeeRepo.save(newEmp); // used to save/updated the data to the DB.
    }

    // c => Update Methods:
    public void updateEmp(Employee emp) {
        employeeRepo.save(emp);
    }

    // d => Delete Methods:
    public void deleteEmp(long id) {
        employeeRepo.deleteById(id);
    }

}

