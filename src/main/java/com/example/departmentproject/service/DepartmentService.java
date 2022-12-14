package com.example.departmentproject.service;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.error.DepartmentNameNotFound;
import com.example.departmentproject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartment();

    public Department getOneDepartment(Long id) throws DepartmentNotFoundException;

    public void deleteDepartment(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentByNameIgnoreCase(String departmentName) throws DepartmentNameNotFound;

}
