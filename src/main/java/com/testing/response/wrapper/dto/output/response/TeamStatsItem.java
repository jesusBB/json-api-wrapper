
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
public class TeamStatsItem {
  /*@JsonProperty("possession")
  private int possession;*/

  @JsonProperty("name")
  private String name;

  @JsonProperty("goalsFavour")
  private int goalsFavour;

  @JsonProperty("goalsAgainst")
  private int goalsAgainst;


}