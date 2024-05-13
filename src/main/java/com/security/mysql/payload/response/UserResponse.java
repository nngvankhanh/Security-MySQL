package com.security.mysql.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String createdAt;
    private boolean enabled;
    private List<RoleResponse> roles;
}
