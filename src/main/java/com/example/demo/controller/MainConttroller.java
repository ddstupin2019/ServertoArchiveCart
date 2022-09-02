package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainConttroller {

    @RequestMapping("/")
    public String home(){
        return "Оно работать возможно";
    }
}

