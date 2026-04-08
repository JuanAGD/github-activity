package com.example.empresa_crud.services;

import com.example.empresa_crud.dto.request.DepartmentRequest;
import com.example.empresa_crud.dto.response.DepartmentResponse;
import com.example.empresa_crud.entities.DepartmentEntity;
import com.example.empresa_crud.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentResponse create(DepartmentRequest departmentRequest){
        DepartmentEntity departmentToSaved = DepartmentEntity.builder()
                .name(departmentRequest.getName())
                .description(departmentRequest.getDescription())
                .build();

        DepartmentEntity departmentSaved =  departmentRepository.save(departmentToSaved);
        DepartmentResponse response = DepartmentResponse.builder()
                .id(departmentSaved.getId())
                .name(departmentSaved.getName())
                .description(departmentSaved.getDescription())
                .build();
        return response;
    }

    public List<DepartmentResponse> departmentList(){
        return departmentRepository.findAll().stream()
                .map(department -> DepartmentResponse.builder()
                        .id(department.getId())
                        .name(department.getName())
                        .description(department.getDescription())
                        .build()
                ).toList();
    }

    public DepartmentResponse showDepartment(Long id){
        DepartmentEntity department = departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException());
        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .build();
    }

    public DepartmentResponse updateDepartment(Long id, DepartmentRequest departmentRequest){
        departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

        DepartmentEntity departmentToUpdated = DepartmentEntity.builder()
                .id(id)
                .name(departmentRequest.getName())
                .description(departmentRequest.getDescription())
                .build();

        DepartmentEntity departmentUpdated = departmentRepository.save(departmentToUpdated);
        return DepartmentResponse.builder()
                .id(departmentUpdated.getId())
                .name(departmentUpdated.getName())
                .description(departmentUpdated.getDescription())
                .build();
    }

    public DepartmentResponse deleteDepartment(Long id){
        DepartmentEntity departmentToDelete = departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException());

        departmentRepository.deleteById(id);

        return DepartmentResponse.builder()
                .id(departmentToDelete.getId())
                .name(departmentToDelete.getName())
                .description(departmentToDelete.getDescription())
                .build();
    }
}
