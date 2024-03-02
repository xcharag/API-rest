package com.springboot.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller //Converted to MVC
//@ResponseBody //Serializer JSON

@RestController //Replace both
public class holaUbicua {
    
    @GetMapping("hola-ubicua") //Assign el endpoint
    public String HolaUbicua(){
        return "Hello World!!!";
    } 
}
