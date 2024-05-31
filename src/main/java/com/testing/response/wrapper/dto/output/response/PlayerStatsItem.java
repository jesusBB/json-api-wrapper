package com.testing.response.wrapper.dto.output.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerStatsItem {
  @JsonProperty("min_player")
  private int minPlayer;

  @JsonProperty("name")
  private String name;

  @JsonProperty("shots_on_target")
  private int shotsOnTarget;

}
