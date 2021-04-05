package com.ayigroup.mepv.security.resgistration;

import com.ayigroup.mepv.security.auth.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationRestController {
    private final AppUserService appUserService;

    @PostMapping("api/v1/registration")
    public String registrationAPI(@RequestBody RegistrationRequest request) {
        appUserService.signUpUser(request);
        return "";
    }
}
