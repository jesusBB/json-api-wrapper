package com.testing.response.wrapper.controller;

import com.testing.response.wrapper.dto.output.response.PlayerStatsItem;
import com.testing.response.wrapper.dto.output.response.TeamStatsItem;
import com.testing.response.wrapper.dto.output.response.TeamStatsItemRecord;
import com.testing.response.wrapper.service.FootballService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(
    value = "/api/v1/football",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class FootballController {
  private final FootballService footballService;

  public FootballController(FootballService footballService) {
    this.footballService = footballService;
  }

  @Operation(
      summary = "Get player stats"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Returns details of a random player",
          content = @Content(
              schema = @Schema(
                  implementation = PlayerStatsItem.class
              )
          )
      ),
  })
  @GetMapping(value = "/players")
  public ResponseEntity<PlayerStatsItem> getPlayerStats() {
    return ResponseEntity.ok(footballService.getPlayerStats());
  }

  @Operation(
      summary = "Get Team stats"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Returns details of a random team",
          content = @Content(
              schema = @Schema(
                  implementation = TeamStatsItemRecord.class
              )
          )
      ),
  })
  @GetMapping(value = "/teams")
  public ResponseEntity<TeamStatsItemRecord> getTeamStats() {
    return ResponseEntity.ok(footballService.getTeamStatsRecord());
  }


  @Operation(
      summary = "Get Team stats"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Returns details of a random team",
          content = @Content(
              schema = @Schema(
                  implementation = TeamStatsItem.class
              )
          )
      ),
  })
  @GetMapping(value = "/teams/{teamId}")
  public ResponseEntity<TeamStatsItem> getTeamStats(@PathVariable String teamId) {
    return ResponseEntity.ok(footballService.getTeamStats(teamId));
  }


}
