package com.example.Springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/restlist")
    public String restlist(){

        return "restlist"; // restlist.html --> JS-fetch() -> REST API

    }
}
