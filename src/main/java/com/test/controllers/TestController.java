package com.test.controllers;

import com.test.models.*;
import com.test.repositories.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

  private final LinkRepository linkRepository;

  public TestController(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  @GetMapping("/")
  String hello(){
    return "Hello Heroku";
  }

  @GetMapping("/links")
  Iterable<Link> getLinks(){
    return linkRepository.findAll();
  }

  @PostMapping("/links")
  Link postLink(@RequestBody Link link){
    linkRepository.save(link);
    return link;
  }

}
