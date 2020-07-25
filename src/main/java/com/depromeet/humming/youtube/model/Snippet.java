package com.depromeet.humming.youtube.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Snippet {

  private final String channelId;
  private final String title;
  private final String channelTitle;

  @JsonCreator
  public Snippet(@JsonProperty("channelId") String channelId, @JsonProperty("title") String title,
      @JsonProperty("channelTitle") String channelTitle) {
    this.channelId = channelId;
    this.title = title;
    this.channelTitle = channelTitle;
  }
}