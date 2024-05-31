package com.testing.response.wrapper.client;

import com.testing.response.wrapper.dto.football.response.FootballPlayerStatsItem;
import com.testing.response.wrapper.dto.football.response.FootballResponseWrapper;
import com.testing.response.wrapper.dto.football.response.FootballTeamStatsItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "footballclient", url = "${football.base-url}")
public interface FootballClient {

  @GetMapping(value = "/players/stats")
  FootballResponseWrapper<FootballPlayerStatsItem> playerStats();


  @GetMapping(value = "/team/stats")
  FootballResponseWrapper<FootballTeamStatsItem> teamStats();

  @GetMapping(value = "/team/stats/{id}")
  FootballResponseWrapper<FootballTeamStatsItem> teamStats(@PathVariable("id") String teamId);
}
