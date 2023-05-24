package com.CashCall.HR.Services;

import com.CashCall.HR.Model.Department;
import com.CashCall.HR.Repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {

  /* Dependencies */
  @Autowired
  private DepartmentRepo departmentRepo;


  /* DB Methods */

  // a => Retrieving Methods:
  public List<Department> getAllDepartments() {
    return departmentRepo.findAll();
  }

  public Department getDepartmentByID(Long id) {
    return departmentRepo.findById(id).orElseThrow();
  }

  public List<Department> getDepartmentByName(String name) {
    return departmentRepo.findByDepartmentName(name);
  }

  // b => Inserting Methods:
  public void addDepartment(Department department) {
    departmentRepo.save(department);
  }

  // c => Update Methods:
  public void updateDepartment(Department department) {
    departmentRepo.save(department);
  }

  // d => Delete Methods:
  public void removeDepartment(long id) {
    departmentRepo.deleteById(id);
  }


}
