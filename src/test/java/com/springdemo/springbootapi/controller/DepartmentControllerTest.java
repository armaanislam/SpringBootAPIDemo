package com.springdemo.springbootapi.controller;

import com.springdemo.springbootapi.entity.Department;
import com.springdemo.springbootapi.error.DepartNotFoundException;
import com.springdemo.springbootapi.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class) // For Using endpoints
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc; // To use the endpoints, we need to mock the MVC

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
//        Department department = Department.builder() // Output Object
//                .departmentName("CSE")
//                .departmentCode("CSE110")
//                .departmentAddress("Dhaka")
//                .departmentId(1L) // When ta data is persisted, this id will be added
//                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder() // Input object
                .departmentName("CSE")
                .departmentAddress("Dhaka")
                .departmentCode("CSE110")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department); // Output vs Input Object
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                        "\t\"departmentName\":\"CSE\",\n" +
                        "\t\"departmentAddress\":\"Dhaka\",\n" +
                        "\t\"departmentCode\":\"CSE110\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Department department = Department.builder() // Input object
                .departmentName("CSE")
                .departmentAddress("Dhaka")
                .departmentCode("CSE110")
                .departmentId(1L)
                .build();

        Mockito.when(departmentService.fetchDepartmentById(1l)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}