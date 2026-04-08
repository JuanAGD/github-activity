package com.example.empresa_crud.services;

import com.example.empresa_crud.dto.request.EmployeeRequest;
import com.example.empresa_crud.dto.response.EmployeeResponse;
import com.example.empresa_crud.entities.DepartmentEntity;
import com.example.empresa_crud.entities.EmployeeEntity;
import com.example.empresa_crud.repositories.DepartmentRepository;
import com.example.empresa_crud.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeResponse create(EmployeeRequest employeeRequest){

        DepartmentEntity department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        EmployeeEntity employeeToSaved = EmployeeEntity.builder()
                .name(employeeRequest.getName())
                .lastname(employeeRequest.getLastname())
                .salary(employeeRequest.getSalary())
                .department(department)
                .build();

        EmployeeEntity employeeSaved = employeeRepository.save(employeeToSaved);
        EmployeeResponse response = EmployeeResponse.builder()
                .id(employeeSaved.getId())
                .name(employeeSaved.getName())
                .lastname(employeeSaved.getLastname())
                .salary(employeeSaved.getSalary())
                .department(employeeSaved.getDepartment().getName())
                .build();
        return response;
    }

    public List<EmployeeResponse> employeeList(){
        return employeeRepository.findAll().stream()
                .map(employee -> EmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .lastname(employee.getLastname())
                        .salary(employee.getSalary())
                        .department(employee.getDepartment().getName())
                        .build()
                ).toList();
    }

    public EmployeeResponse showEmployee(Long id){
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastname(employee.getLastname())
                .salary(employee.getSalary())
                .department(employee.getDepartment().getName())
                .build();
    }

    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest){
        employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        DepartmentEntity department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        EmployeeEntity employeeToSave = EmployeeEntity.builder()
                .id(id)
                .name(employeeRequest.getName())
                .lastname(employeeRequest.getLastname())
                .salary(employeeRequest.getSalary())
                .department(department)
                .build();

        EmployeeEntity employeeUpdated = employeeRepository.save(employeeToSave);
        return EmployeeResponse.builder()
                .id(employeeUpdated.getId())
                .name(employeeUpdated.getName())
                .lastname(employeeUpdated.getLastname())
                .salary(employeeUpdated.getSalary())
                .department(employeeUpdated.getDepartment().getName())
                .build();
    }

    public EmployeeResponse deleteEmployee(Long id) {

        EmployeeEntity employeeToDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        employeeRepository.deleteById(id);

        return EmployeeResponse.builder()
                .id(employeeToDelete.getId())
                .name(employeeToDelete.getName())
                .lastname(employeeToDelete.getLastname())
                .salary(employeeToDelete.getSalary())
                .department(employeeToDelete.getDepartment().getName())
                .build();
    }
}