package com.bikalp.AuthenticationService.Controller;

import com.bikalp.AuthenticationService.Entity.User;
import com.bikalp.AuthenticationService.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok().body(userService.save(user));
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(userService.getAll());
    }

}
