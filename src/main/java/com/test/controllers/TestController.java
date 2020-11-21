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
    firebaseService.sendNotification(link, "eHO1Uea6RomGiew8JZYUWW:APA91bHPPxfst69YOw8G6HwoxpHhL1mq99BMiERZ9ghlC1IMWGPWi5VdPepW0uTKpExfirKWkDDvNiW8LZtMGtCFFA1Ot93NYAi6ypPuUpMxBDK8eSIoiaRWJ-W-4XQYTyDmzPa8CUkr");
    linkRepository.save(link);
    return link;
  }

}
