package com.bikalp.AuthenticationService.Service.Implementation;

import com.bikalp.AuthenticationService.Entity.Role;
import com.bikalp.AuthenticationService.Repository.RoleRepo;
import com.bikalp.AuthenticationService.Service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
