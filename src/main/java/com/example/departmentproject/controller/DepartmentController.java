package com.example.departmentproject.controller;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.error.DepartmentNameNotFound;
import com.example.departmentproject.error.DepartmentNotFoundException;
import com.example.departmentproject.service.DepartmentService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping( "/department")
    public Department addDepartment(@Valid @RequestBody Department department) {
        LOGGER.warn("Inside addDepartment in DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> fetchDepartment() {
        LOGGER.warn("Inside fetchDepartment in DepartmentController");
        return departmentService.getDepartment();
    }

    @GetMapping("/department/{Id}")
    public Department getEachDepartment(@PathVariable("Id") Long id) throws DepartmentNotFoundException {
        LOGGER.warn("Inside getEachDepartment in DepartmentController");
        return departmentService.getOneDepartment(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        LOGGER.warn("Inside deleteDepartment in DepartmentController");
        departmentService.deleteDepartment(id);
        return "Delete Successful";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        LOGGER.warn("Inside updateDepartment in DepartmentController");
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmenyByName(@PathVariable("name") String departmentName) throws DepartmentNameNotFound {
        LOGGER.warn("Inside getDepartmenyByName in DepartmentController");
        return departmentService.getDepartmentByNameIgnoreCase(departmentName);
    }
}
