package com.CashCall.HR.Controllers;

import com.CashCall.HR.Model.Department;
import com.CashCall.HR.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // add Static HTML files
@RestController
@RequestMapping("api/v1")
public class DepartmentController {
    /* Dependencies */
    @Autowired
    private DepartmentServices departmentServices;

    /* Controller Methods */

    // => Retrieving Controller Methods:
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentServices.getAllDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") long id) {
        return departmentServices.getDepartmentByID(id);
    }

    @GetMapping("/department")
    public List<Department> getDepartmentByName(@RequestParam(name = "dName") String name) {
        return departmentServices.getDepartmentByName(name);
    }


    // => Posting Controller Methods:
    @PostMapping("/department/addDept")
    public String addDepartment(@RequestBody Department dept) {
        departmentServices.addDepartment(dept);

        return "Department: " + dept.getDepartmentName() + ", Added Successfully ";
    }

    // => Updating Controller Methods:

    @PutMapping("/department/updateDept")
    public String updateDepartment(@RequestBody Department dept) {
        departmentServices.updateDepartment(dept);

        return "Department: " + dept.getDepartmentName() + ", Updated Successfully ";
    }


    // => Deleting Controller Methods:

    @DeleteMapping("/department/{id}")
    public String removeDepartment(@PathVariable(name = "id") long id) {
        departmentServices.removeDepartment(id);

        return "Department of Id: " + String.valueOf(id) + ", Deleted Successfully ";

    }


}

/*
 *
 * -------
 * Stateful Server @Controller
 * Stateless Restfull => @RestController
 * -------
 *
 *
 *
 *
 *
 * */