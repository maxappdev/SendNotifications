package com.test.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

  @GetMapping("/")
  String hello(){
    return "Hello Heroku";
  }

}
