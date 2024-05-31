package com.testing.response.wrapper.dto.football.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FootballTeamStatsItem {
  @JsonProperty("possession")
  private int possession;

  @JsonProperty("name")
  private String name;

  @JsonProperty("goals_favour")
  private int goalsFavour;

  @JsonProperty("goals_against")
  private int goalsAgainst;

}
