package com.bikalp.AuthenticationService.Service.Implementation;

import com.bikalp.AuthenticationService.Entity.UserRole;
import com.bikalp.AuthenticationService.Repository.UserRoleRepo;
import com.bikalp.AuthenticationService.Service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepo userRoleRepo;

    public UserRoleServiceImpl(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepo.save(userRole);
    }

    @Override
    public UserRole getById(Long id) {
        return userRoleRepo.findById(id).orElse(null);
    }

    @Override
    public List<UserRole> getAll() {
        return userRoleRepo.findAll();
    }

}
