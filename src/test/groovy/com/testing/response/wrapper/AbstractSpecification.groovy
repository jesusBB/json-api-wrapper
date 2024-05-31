package com.testing.response.wrapper

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.*
import static com.github.tomakehurst.wiremock.client.WireMock.get as wiremockGet
import static com.github.tomakehurst.wiremock.client.WireMock.post as wiremockPost
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig

class AbstractSpecification extends Specification {

    static WireMockServer footballMockServer


    def setup() {
        footballMockServer = new WireMockServer(wireMockConfig().port(8081))
        footballMockServer.start()
    }

    def cleanup() {
        footballMockServer.stop()
    }

    protected StubMapping prepareMockServerForUpstreamDown() {
        footballMockServer.stop()
    }


    protected StubMapping prepareMockServerWithLinkChargerResponse200() {
        footballMockServer.stubFor(
                wiremockPost(
                        urlPathEqualTo("/chargers")
                )
                //.withHeader("Authorization", matching("Bearer " + VALID_TOKEN))
                        .withRequestBody(containing("\"chargePointId\":\"EU-ONEAPPTST001\""))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withStatus(201)
                                .withBody(
                                        this.getClass()
                                                .getResource("/dto/DcpLinkedChargerResponse.json").text

                                )))
    }

    protected StubMapping prepareMockToReturnPlayerStats() {
        footballMockServer.stubFor(
                wiremockGet(
                        urlPathEqualTo("/players/stats")
                )
                //.withHeader("Authorization", matching("Bearer " + VALID_TOKEN))
                //.withRequestBody(containing("\"chargePointId\":\"EU-ONEAPPTST001\""))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withStatus(200)
                                .withBody(
                                        this.getClass()
                                                .getResource("/dto/footballPlayerStatsResponse.json").text

                                )))
    }
    protected StubMapping prepareMockToReturnTeamStats() {
        footballMockServer.stubFor(
                wiremockGet(
                        urlPathEqualTo("/team/stats")
                )
                //.withHeader("Authorization", matching("Bearer " + VALID_TOKEN))
                //.withRequestBody(containing("\"chargePointId\":\"EU-ONEAPPTST001\""))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withStatus(200)
                                .withBody(
                                        this.getClass()
                                                .getResource("/dto/footballTeamStatsResponse.json").text

                                )))
    }

    protected StubMapping prepareMockToReturnTeamStatsById() {
        footballMockServer.stubFor(
                wiremockGet(
                        urlPathEqualTo("/team/stats/1234")
                )
                //.withHeader("Authorization", matching("Bearer " + VALID_TOKEN))
                //.withRequestBody(containing("\"chargePointId\":\"EU-ONEAPPTST001\""))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withStatus(200)
                                .withBody(
                                        this.getClass()
                                                .getResource("/dto/footballTeamStatsResponse.json").text

                                )))
    }
}
