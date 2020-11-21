package com.test.controllers;

import com.google.firebase.messaging.*;
import com.test.models.*;
import com.test.notifications.*;
import com.test.repositories.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

  private final LinkRepository linkRepository;
  private final FirebaseMessagingService firebaseService;

  public TestController(LinkRepository linkRepository, FirebaseMessagingService firebaseService) {
    this.linkRepository = linkRepository;
    this.firebaseService = firebaseService;
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
  Link postLink(@RequestBody Link link) throws FirebaseMessagingException {
    firebaseService.sendNotification(link, "fODDtoiRT9SV5kzzvNjIJT:APA91bG02k70CVOyfkC16Rv1Z2qlKDOaDzeXZhZ0dg16pPHEkcRRXWT-yEn2VcSBeU0yHBfmWHo_Wz1ex-8zyfwG3bmnZ7E6AnOBVt-hogJvXZhj5jCvd-Bqlu4EhPZWVVHfbTCmoWbf");
    linkRepository.save(link);
    return link;
  }

}
