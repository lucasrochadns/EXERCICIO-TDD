package com.devsuperior.bds01.resource;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
@RestController
@RequestMapping(value="/department")
public class DepartmentResource {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Page<DepartmentDTO>> findAll(@PageableDefault(size = 12, sort={"name"})Pageable pageable){
       Page<DepartmentDTO> dto = departmentService.findAllPaged(pageable);
       return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id){
        System.out.println(id);
        DepartmentDTO departmentDTO = departmentService.findById(id);
        return ResponseEntity.ok().body(departmentDTO);
    }


}
