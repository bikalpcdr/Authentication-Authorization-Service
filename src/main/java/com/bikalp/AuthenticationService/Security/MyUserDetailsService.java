package com.bikalp.AuthenticationService.Security;

import com.bikalp.AuthenticationService.Entity.User;
import com.bikalp.AuthenticationService.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email).orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "UserName or password not match"));
        return new MyUserDetails(user);
    }
}
