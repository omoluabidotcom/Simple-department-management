package com.example.departmentproject.service;

import com.example.departmentproject.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartment();
}
