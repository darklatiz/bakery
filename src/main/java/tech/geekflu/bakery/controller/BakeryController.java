package tech.geekflu.bakery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
//@RequestMapping("/bakery")
public class BakeryController {

  @GetMapping(value = {"/", "/index"})
  public String home(Model model) {
    model.addAttribute("title", "Welcome Bakery!!");
    return "index";
  }

}
