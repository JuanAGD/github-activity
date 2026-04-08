package com.example.empresa_crud.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String lastname;
    private Double salary;
    private String department;
}
