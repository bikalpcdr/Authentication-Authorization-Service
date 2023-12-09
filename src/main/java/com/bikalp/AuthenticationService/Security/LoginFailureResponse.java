package com.bikalp.AuthenticationService.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginFailureResponse {

    private boolean success;

    private String message;

}
