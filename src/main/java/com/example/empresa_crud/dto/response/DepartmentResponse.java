package com.example.empresa_crud.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class DepartmentResponse {
    private Long id;
    private String name;
    private String description;
}
