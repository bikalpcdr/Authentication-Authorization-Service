package com.bikalp.AuthenticationService.Controller;

import com.bikalp.AuthenticationService.Entity.Role;
import com.bikalp.AuthenticationService.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN',ROLE_CLIENT)")
    public ResponseEntity<Role> save(@RequestBody Role role){
        return ResponseEntity.ok().body(roleService.save(role));
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN',ROLE_CLIENT)")
    public ResponseEntity<Role> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(roleService.getById(id));
    }


    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN',ROLE_CLIENT)")
    public ResponseEntity<List<Role>> getAll(){
        return ResponseEntity.ok().body(roleService.getAll());
    }

}
