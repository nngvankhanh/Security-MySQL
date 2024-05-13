package com.security.mysql.payload.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {
    @NotNull(message = "username may be not null")
    @NotEmpty(message = "username may not be empty")
    @Size(min = 4, max = 12,message = "Character length ranges from 4 to 12")
    private String username;
    @NotNull(message = "password may be not null")
    @NotEmpty(message = "password may not be empty")
    private String password;

}
