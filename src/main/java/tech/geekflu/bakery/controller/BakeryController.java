package tech.geekflu.bakery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.geekflu.bakery.model.Item;

import java.util.List;

@Controller
@RequestMapping("/bakery")
public class BakeryController {

  @GetMapping(value = {"/", "/index"})
  public String home(Model model) {
    model.addAttribute("cakeFactoryTittle", "Cake Factory");
    model.addAttribute("title", "Welcome To Cake Factory!!");
    model.addAttribute("pantriesCategories", List.of("Flatbreads, Pitas & Pizzacrusts", "Cakes and Cupcakes", "Buns, Breads & Rolls", "Desserts & Pastries"));
    model.addAttribute("items", List.of(
        Item.builder()
            .description("Puffy, chewy and oh-so delicious, our tandoori-style naan bites are perfect with your favorite dips, soups or warmed up with a brush of butter—mmm!")
            .name("Member's Mark Tandoori Style Naan Bites (14 oz.)")
            .image("https://scene7.samsclub.com/is/image/samsclub/0019396803062_A?$DT_Zoom$")
            .price(23.56f)
            .build(),
        Item.builder()
            .description("This 8-count package of filled gourmet cupcakes has something for everyone and is a perfect addition to any gathering or party. Choose from four decadent flavors and indulge!")
            .name("Member's Mark Indulgent Filled Gourmet Cupcakes (8 ct.)")
            .price(23.67f)
            .image("https://scene7.samsclub.com/is/image/samsclub/0022910500000_C?$DT_PDP_Image$")
            .build(),
        Item.builder()
            .name("Member's Mark Mixed Berry Topped Cheesecake (75 oz.)")
            .description("Made with real cream cheese topped with strawberries, blackberries, blueberries, and whipped cream")
            .price(56.56f)
            .image("https://scene7.samsclub.com/is/image/samsclub/0022895700000_A?$DT_Zoom$")
            .build(),
        Item.builder()
            .name("Member's Mark Petite White Hoagie Rolls (18 ct.)")
            .description("It will be hard to resist tearing chunks from these fluffy, fresh-baked hoagie rolls! Perfect for sandwiches, our hoagie rolls are baked fresh in club daily.")
            .price(11.45f)
            .image("https://scene7.samsclub.com/is/image/samsclub/0022216900000_A?$DT_Zoom$")
            .build(),
        Item.builder()
            .name("Wonder Classic White Bread (20oz / 2pk)")
            .description("America's favorite white bread brand")
            .price(44.67f)
            .image("https://scene7.samsclub.com/is/image/samsclub/0007225001348_A?$DT_Zoom$")
            .build(),
        Item.builder()
            .name("Member's Mark Garlic Knot Rolls (24 ct.)")
            .description("Give your pasta the perfect companion—these garlic knots are soft, delicious and ready to be enjoyed in less than 10 minutes!")
            .price(67.76f)
            .image("https://scene7.samsclub.com/is/image/samsclub/0022935500000_A?$DT_Zoom$")
            .build()
    ));
    return "shop";
  }



}
