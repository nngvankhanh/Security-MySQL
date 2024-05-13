package com.security.mysql.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RoleResponse {
    private Long id;
    private String name;
}
