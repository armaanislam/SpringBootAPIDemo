package com.springdemo.springbootapi.repository;

import com.springdemo.springbootapi.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager; // It's a part of JPA itself

    @BeforeEach
    void setUp(){
        Department department = Department.builder()
                .departmentName("CSE")
                .departmentCode("CSE110")
                .departmentAddress("Dhaka")
                .build();

        entityManager.persist(department); // Once the testing is done, the entity manager will delete this particular record from database
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "CSE");
    }

}