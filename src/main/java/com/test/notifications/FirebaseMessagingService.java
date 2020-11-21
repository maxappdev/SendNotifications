package com.test.notifications;

import com.google.firebase.messaging.*;
import com.test.models.*;
import java.util.*;
import org.springframework.stereotype.*;

@Service
public class FirebaseMessagingService {

  private final FirebaseMessaging firebaseMessaging;

  public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
    this.firebaseMessaging = firebaseMessaging;
  }


  public String sendNotification(Link link, String token) throws FirebaseMessagingException {

    Notification notification = Notification
        .builder()
        .setTitle(link.getLink())
        .setBody(link.getLink())
        .build();

    Message message = Message
        .builder()
        .setToken(token)
        .setNotification(notification)
        .putAllData(new HashMap<String, String>())
        .build();

    return firebaseMessaging.send(message);
  }

}
