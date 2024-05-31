package com.testing.response.wrapper.mapper;


import com.testing.response.wrapper.dto.football.response.FootballPlayerStatsItem;
import com.testing.response.wrapper.dto.football.response.FootballResponseWrapper;
import com.testing.response.wrapper.dto.football.response.FootballTeamStatsItem;
import com.testing.response.wrapper.dto.output.response.PlayerStatsItem;
import com.testing.response.wrapper.dto.output.response.TeamStatsItem;
import com.testing.response.wrapper.dto.output.response.TeamStatsItemRecord;
import org.springframework.stereotype.Service;

@Service
public class ResponseMapper {

  public PlayerStatsItem mapPlayerStats(
      FootballResponseWrapper<FootballPlayerStatsItem> dcpResponse
  ) {
    return PlayerStatsItem.builder().minPlayer(dcpResponse.getResult().getMinPlayer())
        .name(dcpResponse.getResult().getName())
        .shotsOnTarget(dcpResponse.getResult().getShotsOnTarget()).build();
  }


  public TeamStatsItem mapTeamStats(FootballResponseWrapper<FootballTeamStatsItem> teamStats) {
    return TeamStatsItem.builder().name(teamStats.getResult().getName())
        .goalsAgainst(teamStats.getResult().getGoalsAgainst())
        .goalsFavour(teamStats.getResult().getGoalsFavour())
        .build();
  }


  public TeamStatsItemRecord mapTeamStatsRecord(
    FootballResponseWrapper<FootballTeamStatsItem> teamStats) {
    return TeamStatsItemRecord.builder().name(teamStats.getResult().getName())
        .goalsAgainst(teamStats.getResult().getGoalsAgainst())
        .goalsFavour(teamStats.getResult().getGoalsFavour())
        .build();
  }

}

