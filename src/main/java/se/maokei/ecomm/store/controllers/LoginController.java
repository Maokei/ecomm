package se.maokei.ecomm.store.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.maokei.ecomm.store.command.LoginCommand;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String getLogin(Model model) {
        model.addAttribute("LoginCommand", new LoginCommand());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String postLogin(@Valid @ModelAttribute("LoginCommand") LoginCommand loginCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.info("Bad loginCommand: " + loginCommand);
            return "login";
        }
        return "product";
    }
}
