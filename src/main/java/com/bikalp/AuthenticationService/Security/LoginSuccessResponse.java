package com.bikalp.AuthenticationService.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginSuccessResponse {

    private boolean success;

    private String token;

    private String name;

}
