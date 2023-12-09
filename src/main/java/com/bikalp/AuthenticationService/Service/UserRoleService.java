package com.bikalp.AuthenticationService.Service;

import com.bikalp.AuthenticationService.Entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService {

    UserRole save(UserRole userRole);

    UserRole getById(Long id);

    List<UserRole> getAll();

}
