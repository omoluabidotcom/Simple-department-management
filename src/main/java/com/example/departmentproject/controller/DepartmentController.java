package com.example.departmentproject.controller;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping( "/department")
    public Department addDepartment(@Valid @RequestBody Department department) {

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

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {

        departmentService.deleteDepartment(id);
        return "Delete Successful";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {

        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmenyByName(@PathVariable("name") String departmentName) {

        return departmentService.getDepartmentByName(departmentName);
    }
}
