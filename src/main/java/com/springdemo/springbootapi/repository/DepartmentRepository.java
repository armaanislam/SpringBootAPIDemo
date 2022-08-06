package com.springdemo.springbootapi.repository;

import com.springdemo.springbootapi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> { // <Entity Name, Primary key datatype>

    //public Department findByDepartmentName(String departmentName);

    // There is not builtin method that will fetch the department by name in the JPA Repository; So, we have to create one here
    // The naming convention is fixed here
    public Department findByDepartmentNameIgnoreCase(String departmentName); // CSE and cse both will be fetched

}