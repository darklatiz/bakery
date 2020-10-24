package tech.geekflu.bakery

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.testcontainers.containers.PostgreSQLContainer
import tech.geekflu.bakery.application.BakeryApplicationService
import tech.geekflu.bakery.domain.model.CatalogInformation
import tech.geekflu.bakery.domain.model.Category

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BakeryControllerSpec extends BasicSpecification {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BakeryApplicationService applicationService

    def "Bakery Home Success"() {

        given:
        applicationService.getAllCategoriesInCatalog(true) >> [
                Category.builder().name("Category 1").id(1).build(),
                Category.builder().name("Category 2").id(2).build(),
                Category.builder().name("Category 3").id(3).build(),
                Category.builder().name("Category 4").id(4).build(),
                Category.builder().name("Category 5").id(5).build()
        ]

        applicationService.getAllItemsInCatalog(true) >> [
                CatalogInformation.builder()
                        .description("Desc 01")
                        .name("Name 01")
                        .image("image url 01")
                        .price(1f)
                        .build(),
                CatalogInformation.builder()
                        .description("Desc 02")
                        .name("Name 02")
                        .image("image url 0")
                        .price(2f)
                        .build(),
                CatalogInformation.builder()
                        .description("Desc 03")
                        .name("Name 03")
                        .image("image url 03")
                        .price(3f)
                        .build(),
                CatalogInformation.builder()
                        .description("Desc 04")
                        .name("Name 04")
                        .image("image url 04")
                        .price(4f)
                        .build(),
        ]

        when:
        ResultActions result = mockMvc.perform(get("/bakery/"))

        then:
        result.andExpect(status().isOk())
        result.andReturn().getResponse().getContentAsString()


    }

}
