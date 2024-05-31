
package com.testing.response.wrapper.integration

import com.testing.response.wrapper.AbstractSpecification
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(["test"])
class FootballControllerSpecIT extends AbstractSpecification {

    @Autowired
    MockMvc mockMvc

    def "testing player stats service"(){
        given: "player stats are ready to be returned"
        prepareMockToReturnPlayerStats()

        when: "endpoint is called"
        def response = mockMvc.perform(get("/api/v1/football/players").contentType("application/json"))

        then: "check response"
        System.out.println("Response: " + response)
    }

    def "testing team stats service"(){
        given: "team stats are ready to be returned"
        prepareMockToReturnTeamStats()

        when: "endpoint is called"
        def response = mockMvc.perform(get("/api/v1/football/teams").contentType("application/json"))

        then: "response will indicate it was OK"
        response.andExpect(status().isOk())

        then: "check response"
        def expectedResponseText = this.getClass().getResource("/dto/expected_response/teamStatsResponse.json").text
        JSONAssert.assertEquals(expectedResponseText, response.andReturn().response.contentAsString, false)
        System.out.println("Response: " + response)
    }

    def "testing team stats service by id"(){
        given: "team stats are ready to be returned"
        prepareMockToReturnTeamStatsById()

        when: "endpoint is called"
        def response = mockMvc.perform(get("/api/v1/football/teams/1234").contentType("application/json"))

        then: "response will indicate it was OK"
        response.andExpect(status().isOk())

        then: "check response"
        def expectedResponseText = this.getClass().getResource("/dto/expected_response/teamStatsResponse.json").text
        JSONAssert.assertEquals(expectedResponseText, response.andReturn().response.contentAsString, false)
        System.out.println("Response: " + response)
    }

}
