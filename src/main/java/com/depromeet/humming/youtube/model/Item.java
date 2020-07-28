package com.depromeet.humming.youtube.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Item {
  private final String kind;
  private final Id id;
  private final Snippet snippet;

  @JsonCreator
  public Item(@JsonProperty("kind") String kind, @JsonProperty("id") Id id, @JsonProperty("snippet") Snippet snippet) {
    this.kind = kind;
    this.id = id;
    this.snippet = snippet;
  }
}