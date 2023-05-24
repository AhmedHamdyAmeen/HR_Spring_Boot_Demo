package com.CashCall.HR.Controllers;

import com.CashCall.HR.HrApplication;
import com.CashCall.HR.Model.Employee;
import com.CashCall.HR.Services.EmployeeServices;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Value("${project.path}")
    String filePath;

    @Value("${spring.application.name}")
    String appName;


    private final Logger log = LoggerFactory.getLogger(HrApplication.class);

    /* Dependencies */
    @Autowired
    private EmployeeServices employeeServices;


    /* Controller Methods */

    // => Retrieving Controller Methods:
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        System.out.println("App Name is: " + appName + ", FilePath is: " + filePath);
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

    @GetMapping("/departments/{deptId}/employees") // Get DepartmentEmployees
    // ToDo: "/departments/{deptId}/employees/{empId}" add Controller search about
    //  specific Employee in specific Department.
    public List<Employee> getDepartmentEmployees(@PathVariable(name = "deptId") long id) {
        return employeeServices.getDepartmentEmployees(id);
    }

    // => Posting Controller Methods:
    @PostMapping("/employee/addNewEmp")
    public ResponseEntity<Employee> addNewEmp(@Valid @RequestBody Employee newEmp) {
        // ToDo: Check If the Emp Saved or Not. f
        // try {} catch () {}

        employeeServices.addNewEmp(newEmp);

//        return "Employee: " + newEmp.getFirstName() + " Saved Successfully";
        return new ResponseEntity<Employee>(newEmp, HttpStatus.OK);
//        return ResponseEntity.ok(newEmp);

        /*
         * Note: We use the @RequestBody Annotation with the POST method's Requests.
         * */
    }

    // => Updating Controller Methods:
    @PutMapping("/employee/updateEmp")
    public ResponseEntity<Employee> updateEmp(@Valid @RequestBody Employee emp) {
        employeeServices.updateEmp(emp);

//        return "Employee: " + emp.getFirstName() + " Updated Successfully";
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    // => Deleting Controller Methods:
    @DeleteMapping("/employee/{id}")
    public String removeEmp(@PathVariable(name = "id") long id) {
        employeeServices.deleteEmp(id);

        return "Employee of Id:  " + String.valueOf(id) + " Deleted Successfully";
    }

}

/*
 *
 *
 *
 *
 * */
