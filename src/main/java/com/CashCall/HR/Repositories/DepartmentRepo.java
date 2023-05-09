package com.CashCall.HR.Repositories;

import com.CashCall.HR.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    public List<Department> findByDepartmentName (String departmentName);

}

