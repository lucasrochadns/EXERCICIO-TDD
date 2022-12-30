package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.respositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.bds01.services.exceptions.ResourceNotFoundException;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAllPaged(Pageable pageable){
        return departmentRepository.findAll(pageable).map(DepartmentDTO::new);
    }

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id){
        System.out.println(id);
        Optional<Department> dep = departmentRepository.findById(id);
        Department department = dep.orElseThrow(()-> new ResourceNotFoundException("Entity Not Found"));
        return new DepartmentDTO(department);
    }



}
