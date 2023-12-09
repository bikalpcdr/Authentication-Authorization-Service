package com.bikalp.AuthenticationService.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tb_seq_gen")
    @SequenceGenerator(name = "user_tb_seq_gen",sequenceName = "user_tb_seq",allocationSize = 1)

    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String fullName;

    private String password;

    private boolean isActive;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserRole> role;

}
