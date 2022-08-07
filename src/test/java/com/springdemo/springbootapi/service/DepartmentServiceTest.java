package com.springdemo.springbootapi.service;

import com.springdemo.springbootapi.entity.Department;
import com.springdemo.springbootapi.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest // To define this class as Test Hanler
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach // This method will be called before running each of the test methods
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentAddress("IT-06")
                .departmentAddress("Dhaka")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data Based on Valid Department Name")
//    @Disabled // If we want to disable any test case
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departName = "IT";
        Department found = departmentService.fetchDepartmentByName(departName);
        assertEquals(departName, found.getDepartmentName());
    }
}