package com.example.departmentproject.service;

import com.example.departmentproject.entity.Department;
import com.example.departmentproject.error.DepartmentNameNotFound;
import com.example.departmentproject.error.DepartmentNotFoundException;
import com.example.departmentproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getOneDepartment(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()) {

            throw new DepartmentNotFoundException("Department with ID " + id + " doesn't exists");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentDB = departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {

            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {

            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {

            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department getDepartmentByNameIgnoreCase(String departmentName) throws DepartmentNameNotFound {

        //return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

        Optional<Department> department = Optional.ofNullable(departmentRepository.findByDepartmentNameIgnoreCase(departmentName));

        if(!department.isPresent()) {

            throw new DepartmentNameNotFound("Department with the name "+ departmentName+" doesn't exist");
        }

        return department.get();
    }

}
