package com.ayigroup.mepv.security.resgistration;

import com.ayigroup.mepv.security.auth.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/signup")
    public String registrationPage(Model model) {
        model.addAttribute("user", new RegistrationRequest());
        return "new-user";
    }

    @PostMapping("/signup/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") RegistrationRequest request,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-user";
        }
        appUserService.signUpUser(request);
        return "redirect:/login";
    }
}
