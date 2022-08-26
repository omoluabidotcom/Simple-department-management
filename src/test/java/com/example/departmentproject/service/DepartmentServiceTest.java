package com.example.departmentproject.service;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentAddress("Garki")
                .departmentCode("HR-05")
                .departmentName("HR")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("HR"))
                .thenReturn(department);

    }

    @Test
    //@DisplayName("When name is valid")
    public void whenDepartmentNameValid_DepartmentShouldFound() {

        String departmentName = "HR";
        Department found = departmentService.getDepartmentByNameIgnoreCase(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}