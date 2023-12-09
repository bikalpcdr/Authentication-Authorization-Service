package com.bikalp.AuthenticationService.Repository;

import com.bikalp.AuthenticationService.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository <UserRole, Long> {
}
