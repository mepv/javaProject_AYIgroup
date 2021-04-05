package com.ayigroup.mepv.security.resgistration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    @JsonProperty("requestUser")
    @NotEmpty
    @Size(min = 3)
    private String requestUser;
    @JsonProperty("password")
    @NotEmpty
    @Size(min = 3)
    private String password;
}
