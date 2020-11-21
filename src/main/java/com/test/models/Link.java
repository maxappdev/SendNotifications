package com.test.models;

import javax.persistence.*;

@Entity
public class Link {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String link;

}
