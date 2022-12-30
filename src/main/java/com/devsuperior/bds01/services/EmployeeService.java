package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.respositories.DepartmentRepository;
import com.devsuperior.bds01.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageable){
        return employeeRepository.findAll(pageable).map(EmployeeDTO::new);
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id){
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee employee = emp.orElseThrow(()-> new ResolutionException("Entity Not Found"));
        return new EmployeeDTO(employee);
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO employeeDTO){
        Department department = departmentRepository.getOne(employeeDTO.getDepartmentId());
        Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getEmail(),department);
        employee = employeeRepository.save(employee);
        return new EmployeeDTO(employee);
    }

}
