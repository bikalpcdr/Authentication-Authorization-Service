package com.bikalp.AuthenticationService.Controller;

import com.bikalp.AuthenticationService.Entity.UserRole;
import com.bikalp.AuthenticationService.Service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_role")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserRole> save(@RequestBody UserRole userRole){
        return ResponseEntity.ok().body(userRoleService.save(userRole));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserRole> getById(Long id){
        return ResponseEntity.ok().body(userRoleService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserRole>> getAll(){
        return ResponseEntity.ok().body(userRoleService.getAll());
    }
}
