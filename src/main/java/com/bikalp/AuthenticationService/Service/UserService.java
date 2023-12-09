package com.bikalp.AuthenticationService.Service;

import com.bikalp.AuthenticationService.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    User getById(Long id);

    List<User> getAll();

}
