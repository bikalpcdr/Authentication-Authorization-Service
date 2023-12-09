package com.bikalp.AuthenticationService.Security;

import com.bikalp.AuthenticationService.Utils.SecurityUtilsConstant;
import lombok.*;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationToken {

    private Authentication authentication;

    private String token;

    private LocalDateTime dateTime;

    public boolean isExpire(){
        return dateTime.plusSeconds(SecurityUtilsConstant.EXPIRE_TIME/1000).isBefore(LocalDateTime.now());
    }

    public void renew(){
        dateTime = LocalDateTime.now();
    }


}
