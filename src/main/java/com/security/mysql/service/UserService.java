package com.security.mysql.service;

import com.security.mysql.payload.request.LoginRequest;
import com.security.mysql.payload.request.RegisterRequest;
import com.security.mysql.payload.response.UserResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String login(LoginRequest loginRequest);
    String register(RegisterRequest registerRequest);
    String refresh(String username);
    UserResponse userInfo(String username);

}
