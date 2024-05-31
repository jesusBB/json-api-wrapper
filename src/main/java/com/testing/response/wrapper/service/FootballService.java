
package com.testing.response.wrapper.service;

import com.testing.response.wrapper.client.FootballClient;
import com.testing.response.wrapper.dto.output.response.PlayerStatsItem;
import com.testing.response.wrapper.dto.output.response.TeamStatsItem;
import com.testing.response.wrapper.mapper.RequestMapper;
import com.testing.response.wrapper.mapper.ResponseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FootballService {
  private final FootballClient footballClient;
  private final ResponseMapper responseMapper;
  private final RequestMapper requestMapper;

  public FootballService(
      FootballClient footballClient,
      ResponseMapper responseMapper,
      RequestMapper requestMapper
  ) {
    this.footballClient = footballClient;
    this.responseMapper = responseMapper;
    this.requestMapper = requestMapper;
  }

  public PlayerStatsItem getPlayerStats() {
    return responseMapper.mapPlayerStats(
        footballClient.playerStats());
  }

  public TeamStatsItem getTeamStats() {
    return responseMapper.mapTeamStats(footballClient.teamStats());
  }

  /*public TeamStatsItemRecord getTeamStatsRecord() {
    return responseMapper.mapTeamStatsRecord(footballClient.teamStats());
  }*/


  public TeamStatsItem getTeamStats(String teamId) {
    return responseMapper.mapTeamStats(footballClient.teamStats(teamId));
  }


}
