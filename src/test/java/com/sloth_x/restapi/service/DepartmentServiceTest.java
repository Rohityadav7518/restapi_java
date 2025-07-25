package com.sloth_x.restapi.service;

import com.sloth_x.restapi.entity.Department;
import com.sloth_x.restapi.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department =
                Department.builder()
                        .DepartmentName("IT")
                        .DepartmentAddress("Jaipur")
                        .DepartmentId(1l)
                        .DepartmentCode("IT-06)")
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = " IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName ,found.getDepartmentName());
    }
}