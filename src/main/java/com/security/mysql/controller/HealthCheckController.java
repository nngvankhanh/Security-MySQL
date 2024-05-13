package com.security.mysql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/api/healthcheck")
@RequiredArgsConstructor
public class HealthCheckController {
    @GetMapping("/health")
    public ResponseEntity<?> healthCheck(){
        try{
            String computerName = InetAddress.getLocalHost().getHostName();
            return ResponseEntity.ok("ok, computer name: "+computerName);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("failed");
        }
    }
}
