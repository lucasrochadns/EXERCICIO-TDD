package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDTO {

    private Long id;
    private String name;
    private List<EmployeeDTO> employees = new ArrayList<>();

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public DepartmentDTO(Department entity, List<Employee> employees){
        this(entity);
        employees.forEach(x -> this.employees.add(new EmployeeDTO(x)));
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
