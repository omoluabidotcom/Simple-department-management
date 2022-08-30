package com.example.departmentproject.service;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.error.DepartmentNameNotFound;
import com.example.departmentproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

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

//        Mockito.when(departmentRepository.findById(1L))
//                .thenReturn(Optional.ofNullable(department));

    }

    @Test
    @DisplayName("When deparment name is valid")
    public void whenDepartmentNameValid_DepartmentShouldFound() throws DepartmentNameNotFound {

        String departmentName = "HR";
        Department found = departmentService.getDepartmentByNameIgnoreCase(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }

//    @Test
//    public void whenDepartmentUpdate_DepartmentShouldFound() {
//
//        Department inputDepartment = Department.builder()
//                .departmentAddress("Garki")
//                .departmentName("HR")
//                .departmentCode("HR-05")
//                .departmentId(1L)
//                .build();
//
//        Department found = departmentService.updateDepartment(1L, inputDepartment);
//
//        assertEquals(found.getDepartmentName(), "HR");
//    }

}