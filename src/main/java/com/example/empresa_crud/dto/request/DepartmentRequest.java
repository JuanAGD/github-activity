package com.example.empresa_crud.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
@Builder
public class DepartmentRequest {
    private String name;
    private String description;
}
