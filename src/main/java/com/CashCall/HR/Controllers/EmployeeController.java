package com.CashCall.HR.Controllers;

import com.CashCall.HR.HrApplication;
import com.CashCall.HR.Model.Employee;
import com.CashCall.HR.Services.EmployeeServices;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(HrApplication.class);

    /* Dependencies */
    @Autowired
    private EmployeeServices employeeServices;


    /* Controller Methods */

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeServices.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeByID(@PathVariable long id) {
        return employeeServices.findEmployeeByID(id);
    }

    @RequestMapping("/log")
    public String log() {
        // Logging various log level messages
        log.trace("Log level: TRACE");
        log.info("Log level: INFO");
        log.debug("Log level: DEBUG");
        log.error("Log level: ERROR");
        log.warn("Log level: WARN");

        return "Hey! You can check the output in the logs";
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployeeByFirstName(@RequestParam(name = "name") String firstName) {
        log.info(firstName);
        return employeeServices.findEmployeeByFirstName(firstName);
    }

    @GetMapping("employee/search")
    public List<Employee> employeeSearch(@RequestParam(name = "fName") String firstName, @RequestParam(name = "lName") String lastName) {
        return employeeServices.employeeSearch(firstName, lastName);
    }

}



/*
 *
 *  Ctrl + Alt + L ==> Format File Code
 *  ---------------- **
 *
 *
 *
 *
 *
 *
 *
 *
 *  ---------------- **
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */

