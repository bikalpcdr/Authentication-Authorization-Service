package com.bikalp.AuthenticationService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_role", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_tb_seq_gen")
    @SequenceGenerator(name = "user_role_tb_seq_gen", sequenceName = "user_role_tb_seq", allocationSize = 1)
    private Long id;

    private  boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

}
