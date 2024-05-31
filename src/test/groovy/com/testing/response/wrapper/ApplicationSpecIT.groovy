
package com.testing.response.wrapper

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(["test"])
class ApplicationSpecIT extends Specification {

    def "Application starts"() {

        when: "application starts up"

        then: "there are no errors"
        noExceptionThrown()
    }
}
