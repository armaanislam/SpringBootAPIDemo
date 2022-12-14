package com.springdemo.springbootapi.service;

import com.springdemo.springbootapi.entity.Department;
import com.springdemo.springbootapi.error.DepartNotFoundException;
import com.springdemo.springbootapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll(); // This will find all the list of departments from the database as list and send back
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartNotFoundException {
//        return departmentRepository.findById(departmentId).get(); // .findById(departmentId) is extra, we need to use .get() to fetch the department by id
        Optional<Department> department = departmentRepository.findById(departmentId); // .findById(departmentId) is extra, we need to use .get() to fetch the department by id
        if(!department.isPresent()) {
            throw new DepartNotFoundException("Department Not Avaiable");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) { // Not Null && Not Blank
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
