package com.test.models;

import javax.persistence.*;

@Entity
public class Link {

  public Link(){}

  public Link(String link){
    this.link = link;
  }

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String link;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
