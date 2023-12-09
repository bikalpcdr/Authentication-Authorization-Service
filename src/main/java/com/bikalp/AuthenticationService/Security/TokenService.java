package com.bikalp.AuthenticationService.Security;

import org.springframework.security.core.Authentication;

public interface TokenService {

    Authentication getAuthenticationByToken(String token);

    String getTokenByAuthentication(Authentication authentication);

}
