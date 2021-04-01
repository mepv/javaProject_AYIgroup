package com.ayigroup.mepv.security.resgistration;

import com.ayigroup.mepv.security.auth.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationRestController {
    private final AppUserService appUserService;

    @PostMapping("api/v1/registration")
    @PreAuthorize("hasAuthority('admin:write')")
    public String registrationAPI(@RequestBody RegistrationRequest request) {
        appUserService.signUpUser(request);
        return "";
    }
}
