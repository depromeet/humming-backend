package com.depromeet.humming.youtube.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Id {

  private final String kind;
  private final String videoId;
  private final String channelId;
  private final String playlistId;

  @JsonCreator
  public Id(@JsonProperty("kind") String kind, @JsonProperty("videoId") String videoId,
      @JsonProperty("channelId") String channelId, @JsonProperty("playlistId") String playlistId) {
    this.kind = kind;
    this.videoId = videoId;
    this.channelId = channelId;
    this.playlistId = playlistId;
  }
}