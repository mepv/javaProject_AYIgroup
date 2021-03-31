package com.ayigroup.mepv.security.resgistration;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String requestUser;
    private String password;
}
