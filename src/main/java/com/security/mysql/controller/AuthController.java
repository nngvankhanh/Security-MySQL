package com.security.mysql.controller;

import com.security.mysql.payload.request.LoginRequest;
import com.security.mysql.payload.request.RegisterRequest;
import com.security.mysql.payload.response.UserResponse;
import com.security.mysql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            String message = "";
            for (String key : errors.keySet()) {
                message += key + " : " + errors.get(key) + "\n";
            }
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        String token = userService.login(loginRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            String message = "";
            for (String key : errors.keySet()) {
                message += key + " : " + errors.get(key) + "\n";
            }
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        String token = userService.register(registerRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
    @GetMapping("/refresh")
    private String refresh(HttpServletRequest request){
        String username = request.getRemoteUser();
        return userService.refresh(username);
    }
    @GetMapping("/user-info")
    private ResponseEntity<?> userInfo(HttpServletRequest request){
        String username = request.getRemoteUser();
        UserResponse userResponse = userService.userInfo(username);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}
