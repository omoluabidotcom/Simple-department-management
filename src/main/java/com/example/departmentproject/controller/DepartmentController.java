package com.example.departmentproject.controller;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping( "/department")
    public Department addDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }
}
