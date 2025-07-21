package com.sloth_x.restapi.service;

import com.sloth_x.restapi.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartment();

   public  Department fetchDepartmentById(long departmentID);

   public void deleteDepartmentById(long departmentId);

   public Department updateDepartment(long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
