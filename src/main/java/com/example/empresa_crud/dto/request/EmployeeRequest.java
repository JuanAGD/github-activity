package com.example.empresa_crud.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class EmployeeRequest {
    private String name;
    private String lastname;
    private Double salary;
    private Long departmentId;
}
