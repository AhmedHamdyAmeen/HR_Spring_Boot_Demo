package com.CashCall.HR.Repositories;

import com.CashCall.HR.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // There are many ways to create repository method to perform
    // DB operation:

    /* 1. Use the Default Method provided by the Spring Data JPA */

    /* 2. Using The Method Signature ( Derived Query Methods or queryByName Method) */
    public List<Employee> findByFirstName(String firstName);
    // findByFirstNameOrLastName => Spring Boot convert that MethodSignature to appropriate SQLQuery.


    /* 3. JPQL =>> Java Persistence Query Language */
    @Query("SELECT emp FROM Employee emp WHERE emp.firstName = :firstNameBind AND emp.lastName = :lastNameBind")
    public List<Employee> empSearch(@Param("firstNameBind") String firstName, @Param("lastNameBind") String lastName);
    /*
     * Notes: JPQL querying the Java Entities Object & their Attributes not the DB tables.
     * So, We type the name of the Entities and their attributes not the name of the DB tables.
     *
     * Entities/ Entity Classes: Representation for the DB tables and their columns
     * :firstNameBind ==> FirstBind Variable, variable will be passed to the query at the runtime.
     *
     *  @Param => maps the param passed with the QueryBindParma
     **/

    /* 4. Custom Native SQL Query */
    @Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
    public List<Employee> findAllEmployeesNative();


}

/*
 * The Repository can extends:
 *   - CrudRepository
 *   - JpaRepository<ModelName, PrimaryKey_DataType>
 *   - MongoRepository
 *
 * ------- **
 * JPQL: Java Persistence Query Language.
 *
 *
 * 
 *
 *
 *
 * */


