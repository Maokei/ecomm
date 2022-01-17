package se.maokei.ecomm.store.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@ConditionalOnExpression("${app.controller.product.enabled:false}")
@Controller
public class ProductController {

  @RequestMapping("/product")
  private String getProducts() {
    return "product";
  }
}
