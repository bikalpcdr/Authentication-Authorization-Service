package com.bikalp.AuthenticationService.Security;

import com.bikalp.AuthenticationService.Utils.SecurityUtilsConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService  {

    Map<String, AuthenticationToken> map = new HashMap<>();

    @Override
    public Authentication getAuthenticationByToken(String token) {
        AuthenticationToken authenticationToken = map.getOrDefault(token, new AuthenticationToken());
        return !authenticationToken.  isExpire() ? authenticationToken.getAuthentication() : null;
    }

    @Override
    public String getTokenByAuthentication(Authentication authentication) {
        String token = authentication.getName();
        AuthenticationToken authenticationToken = generateNewToken(token);
        authenticationToken.setAuthentication(authentication);
        map.put(authenticationToken.getToken(), authenticationToken);
        return authenticationToken.getToken();
    }

    private AuthenticationToken generateNewToken(String username){
        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setDateTime(LocalDateTime.now());

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(SecurityUtilsConstant.EXPIRE_TIME + System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, SecurityUtilsConstant.SECRET)
                .compact();
        authenticationToken.setToken(SecurityUtilsConstant.TOKEN_PREFIX+token);
        return authenticationToken;
    }

}
