package se.maokei.ecomm.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    private String getProducts() {
        return "login";
    }
}
