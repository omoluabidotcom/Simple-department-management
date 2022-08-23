package com.example.departmentproject.repository;

import com.example.departmentproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //public Department findByDepartmentNameIgnoreCase(String departmentName);
    public Department findByDepartmentName(String departmentName);
}
