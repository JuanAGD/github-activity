package com.example.empresa_crud.controllers;

import com.example.empresa_crud.dto.request.DepartmentRequest;
import com.example.empresa_crud.dto.response.DepartmentResponse;
import com.example.empresa_crud.services.DepartmentService;
import com.example.empresa_crud.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentResponse create(@RequestBody DepartmentRequest request){
        return departmentService.create(request);
    }

    @GetMapping
    public List<DepartmentResponse> departmentList(){
        return departmentService.departmentList();
    }

    @PostMapping("{id}")
    public DepartmentResponse showDepartment(Long id){
        return departmentService.showDepartment(id);
    }

    @PutMapping("{id}")
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request){
        return departmentService.updateDepartment(id, request);
    }
}
