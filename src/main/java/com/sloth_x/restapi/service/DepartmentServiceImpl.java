package com.sloth_x.restapi.service;


import com.sloth_x.restapi.entity.Department;
import com.sloth_x.restapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return  departmentRepository.save(department) ;
    }
}
