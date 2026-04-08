package com.example.empresa_crud.controllers;

import com.example.empresa_crud.dto.request.EmployeeRequest;
import com.example.empresa_crud.dto.response.EmployeeResponse;
import com.example.empresa_crud.services.DepartmentService;
import com.example.empresa_crud.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
/**
 * Hola chavales
 */
@RequiredArgsConstructor
public class EmployeeControlller {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest request){
        return employeeService.create(request);
    }

    @GetMapping
    public List<EmployeeResponse> employeeList(){
        return employeeService.employeeList();
    }

    @PostMapping("{id}")
    public EmployeeResponse showEmployee(@PathVariable Long id){
        return employeeService.showEmployee(id);
    }

    @PutMapping("{id}")
    public EmployeeResponse updateEmployee(@PathVariable Long id,@RequestBody EmployeeRequest request){
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("{id}")
    public EmployeeResponse deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
