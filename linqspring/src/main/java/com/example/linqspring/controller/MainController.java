package com.example.linqspring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
public class MainController {
    @GetMapping("/")
    public String hell(){
        return "connection successful"
;    }
}
