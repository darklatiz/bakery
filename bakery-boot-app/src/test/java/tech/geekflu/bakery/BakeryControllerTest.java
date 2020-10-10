package tech.geekflu.bakery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tech.geekflu.bakery.application.BakeryApplicationService;
import tech.geekflu.bakery.controller.BakeryController;
import tech.geekflu.bakery.domain.model.Category;
import tech.geekflu.bakery.domain.model.Item;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BakeryController.class)
class BakeryControllerTest extends BaseTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BakeryApplicationService bakeryApplicationService;

  @Test
  void test_bakery_home_page() throws Exception {
    Category c = Category.builder()
        .id(1L)
        .isActive(true)
        .name("Panes de muerto")
        .build();

    when(bakeryApplicationService.getAllCategoriesInCatalog(true))
        .thenReturn(List.of(c));

    String theDesc = "Delicioso pan de muerto relleno de nata";
    String theItemsName = "Pan de muerto relleno de nata";
    String theImageUrl = "Image URL";
    float thePrice = 23.43f;
    when(bakeryApplicationService.getAllItemsInCatalog(true))
        .thenReturn(List.of(Item.builder()
            .name(theItemsName)
            .description(theDesc)
            .image(theImageUrl)
            .price(thePrice)
            .category(c)
            .build()));
    ResultActions resultActions = this.mockMvc.perform(get("/bakery/index").accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk());

    String response = resultActions.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
    assertThat(response).contains(c.getName())
        .contains(theItemsName)
        .contains(theDesc)
        .contains(theImageUrl)
        .contains(String.valueOf(thePrice));

  }

}
