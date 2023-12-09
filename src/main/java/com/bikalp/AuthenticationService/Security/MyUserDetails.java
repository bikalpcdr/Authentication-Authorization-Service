package com.bikalp.AuthenticationService.Security;

import com.bikalp.AuthenticationService.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String email;

    private String password;

    private boolean isActive;

    private String fullName;

    private List<? extends GrantedAuthority> authorities;


    public MyUserDetails(User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.fullName = user.getFullName();
        this.isActive = user.isActive();
        this.authorities = Arrays.stream(getRole(user).split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public String getFullName(){
        return fullName;
    }

    public String getRole(User user){
        if(user.getRole() == null || user.getRole().isEmpty())
            return "ROLE_CLIENT";

        return user.getRole().stream().map(x->"ROLE"+x.getRole().getName()).collect(Collectors.joining(","));
    }

}
