package com.testing.response.wrapper.service

import com.testing.response.wrapper.dto.football.response.FootballResponseWrapper
import com.testing.response.wrapper.dto.football.response.FootballTeamStatsItem
import com.testing.response.wrapper.mapper.ResponseMapper
import spock.lang.Specification

class ResponseMapperSpec extends Specification {

    def responseMapper = new ResponseMapper()

    def "test team mapper response"() {
        given: "a list of footballTeamStatsItem object"
        def footballResponse = FootballResponseWrapper<FootballTeamStatsItem>.builder()
                .result(FootballTeamStatsItem.builder()
                        .name("Cadiz CF")
                        .goalsAgainst(3).goalsFavour(0).build()).build()

        when: "calling response mapper"
        def outputResponse = responseMapper.mapTeamStats(footballResponse)

        then: "response is as expected"
        outputResponse.name == "Cadiz CF"
        outputResponse.goalsAgainst == 3
        outputResponse.goalsFavour == 0

    }


}
