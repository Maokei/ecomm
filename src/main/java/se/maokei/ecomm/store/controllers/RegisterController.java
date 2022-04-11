package se.maokei.ecomm.store.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@ConditionalOnExpression("${app.controller.register.enabled:false}")
@Controller
public class RegisterController {
    @RequestMapping("/register")
    private String getProducts() {
        return "register";
    }
}
