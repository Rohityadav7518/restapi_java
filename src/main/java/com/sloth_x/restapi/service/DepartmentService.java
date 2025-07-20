package com.sloth_x.restapi.service;

import com.sloth_x.restapi.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartment();
}
