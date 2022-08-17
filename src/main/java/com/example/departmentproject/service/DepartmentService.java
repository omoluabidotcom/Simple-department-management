package com.example.departmentproject.service;

import com.example.departmentproject.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartment();

    public Department getOneDepartment(Long id);

    public void deleteDepartment(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentByName(String departmentName);
}
