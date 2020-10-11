package tech.geekflu.bakery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.geekflu.bakery.application.BakeryApplicationService;
import tech.geekflu.bakery.domain.model.Category;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bakery")
public class BakeryController {

  @Autowired
  private BakeryApplicationService bakeryApplicationService;

  @GetMapping(value = {"/", "/index"})
  public String home(Model model) {
    model.addAttribute("cakeFactoryTittle", "Cake Factory");
    model.addAttribute("title", "Welcome To Cake Factory!!");
    model.addAttribute("pantriesCategories", bakeryApplicationService.getAllCategoriesInCatalog(true)
        .stream()
        .sorted(Comparator.comparing(Category::getName))
        .collect(Collectors.toList())
    );
    model.addAttribute("items", bakeryApplicationService.getAllItemsInCatalog(true));
    return "shop";
  }
}
