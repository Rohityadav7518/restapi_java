package com.sloth_x.restapi.controller;


import com.sloth_x.restapi.entity.Department;
import com.sloth_x.restapi.error.DepartmentNotFoundException;
import com.sloth_x.restapi.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save department  department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartment() {
        LOGGER.info("Inside fetchAllDepartment  department controller");
        return departmentService.fetchAllDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") long departmentID) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public  Department fetchDepartmentByName (@PathVariable("name") String departmentName){
  return  departmentService.fetchDepartmentByName(departmentName);
    }

}
