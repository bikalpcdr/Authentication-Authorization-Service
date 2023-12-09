package com.bikalp.AuthenticationService.Service;

import com.bikalp.AuthenticationService.Entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role save(Role role);

    Role getById(Long id);

    List<Role> getAll();

}
