package com.depromeet.humming.youtube.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Youtube {

  private final String kind;
  private final List<Item> items;

  @JsonCreator
  public Youtube(@JsonProperty("kind") String kind, @JsonProperty("items") List<Item> items) {
    this.kind = kind;
    this.items = items;
  }
}