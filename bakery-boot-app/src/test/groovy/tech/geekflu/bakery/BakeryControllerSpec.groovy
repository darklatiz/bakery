package tech.geekflu.bakery

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BakeryControllerSpec extends BasicSpecification {

    @Autowired
    private MockMvc mockMvc;

    def "Bakery Home Success"() {

        given:

        when:
        ResultActions result = mockMvc.perform(get("/bakery/"))

        then:
        result.andExpect(status().isOk())
        result.andReturn().getResponse().getContentAsString()

    }

}
