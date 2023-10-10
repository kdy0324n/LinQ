package com.example.linqspring.controller;

import com.example.linqspring.dto.ResponseDto;
import com.example.linqspring.dto.SignInDto;
import com.example.linqspring.dto.SignInResponseDTO;
import com.example.linqspring.dto.SignUpDto;
import com.example.linqspring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?>signUp(@RequestBody SignUpDto requestBody){
        System.out.println(requestBody.toString());
        ResponseDto<?>result = authService.signUp(requestBody);
        return result;
    }
    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDTO>signIn(@RequestBody SignInDto requestBody){
        ResponseDto<SignInResponseDTO>result = authService.signIn(requestBody);
        return result;
    }
}
