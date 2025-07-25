package com.sloth_x.restapi.service;


import com.sloth_x.restapi.entity.Department;
import com.sloth_x.restapi.error.DepartmentNotFoundException;
import com.sloth_x.restapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(long departmentID) throws DepartmentNotFoundException {
        Optional<Department> department=
                departmentRepository.findById(departmentID);
        if (!department.isPresent()){
            throw  new DepartmentNotFoundException("Department Not Avilable");
        }

        return  department.get();
    }

    @Override
    public void deleteDepartmentById(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(long departmentId, Department department) {
        Department departmentDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
