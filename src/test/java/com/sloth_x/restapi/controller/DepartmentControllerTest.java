package com.sloth_x.restapi.controller;

import com.sloth_x.restapi.entity.Department;
import com.sloth_x.restapi.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
     private MockMvc mockMvc;

    @MockitoBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department =
                Department.builder()
                        .DepartmentName("IT")
                        .DepartmentId(1l)
                        .DepartmentCode("IT-006 ")
                        .DepartmentAddress("JAIPUR")
                        .build();

    }

    @Test
    void saveDepartment() {
        Department inputDepartment =
                Department.builder()
                        .DepartmentName("IT")
                        .DepartmentCode("IT-006 ")
                        .DepartmentAddress("JAIPUR")
                        .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

//        implement here request builder mvc i cannot find them from
    }

    @Test
    void fetchDepartmentById() {
    }
}