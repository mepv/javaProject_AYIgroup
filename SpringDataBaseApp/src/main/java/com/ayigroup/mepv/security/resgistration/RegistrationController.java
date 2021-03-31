package com.ayigroup.mepv.security.resgistration;

import com.ayigroup.mepv.security.auth.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/signup")
    public String registrationPage(Model model) {
        model.addAttribute("user", new RegistrationRequest());
        return "new-user";
    }

    @PostMapping("/signup/saveUser")
    public String saveUser(@ModelAttribute("user") RegistrationRequest request) {
        System.out.println("controller implemented");
        appUserService.signUpUser(request);
        return "redirect:/login";
    }
}
