package tech.geekflu.bakery;

import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tech.geekflu.bakery.application.BakeryApplicationService;
import tech.geekflu.bakery.controller.BakeryController;
import tech.geekflu.bakery.model.Category;
import tech.geekflu.bakery.model.Item;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BakeryController.class)
public class BakeryApplicationTests {

	@Autowired
	WebClient webClient;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BakeryApplicationService bakeryApplicationService;

	@Test
	void contextLoads() throws Exception {
		when(this.bakeryApplicationService.getAllItemsInCatalog(true))
				.thenReturn(List.of(Item.builder()
						.category(Category.builder()
								.id(1L)
								.isActive(true)
								.name("Main Category")
								.build())
						.image("http://www.image.com/url")
						.price(23.43f)
						.description("Descripcion del item")
						.build()));
		this.mockMvc.perform(get("/bakery/index").accept(MediaType.TEXT_PLAIN))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Main Category"));
	}

}
