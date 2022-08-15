package com.example.departmentproject.controller;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping( "/department")
    public Department addDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> fetchDepartment() {

        return departmentService.getDepartment();
    }

    @GetMapping("/department/{Id}")
    public Department getEachDepartment(@PathVariable("Id") Long id) {

        return departmentService.getOneDepartment(id);
    }
}
