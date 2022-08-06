package com.springdemo.springbootapi.controller;

import com.springdemo.springbootapi.entity.Department;
import com.springdemo.springbootapi.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired // The departmentservice object from the DepartmentService class will be autowired to this particular reference; so we don't have to use the new keyword to create that object
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class); // Logger from slf4j

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) { // A JSON object will come here, and we want to convert the JSON type to the entity type that is Department Type, for that we use @Requestbody, //@Valid is used as we used NotBlank in depaertmentName in DepartmentController
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department); // .saveDepartment in both places should match; When we get the data, we call the service layer to do the business logic and then call the repository layer to save it
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList(); // We are not taking any inputs we have to send the data back
    }

    @GetMapping("/departments/{id}") // id = path variable
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) { // {id} this is attached to departmentId
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
