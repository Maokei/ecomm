package se.maokei.ecomm.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

  @RequestMapping("/product")
  private String getProducts() {
    return "product";
  }
}
