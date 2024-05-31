package com.testing.response.wrapper.dto.output.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record TeamStatsItemRecord (@JsonProperty("name") String name,
                                   @JsonProperty("goalsFavour") int goalsFavour,
                                   @JsonProperty("goalsAgainst") int goalsAgainst) {

}

