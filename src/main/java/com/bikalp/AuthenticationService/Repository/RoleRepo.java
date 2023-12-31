package com.bikalp.AuthenticationService.Repository;

import com.bikalp.AuthenticationService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
