package com.bikalp.AuthenticationService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_tb_seq_gen")
    @SequenceGenerator(name ="roles_tb_seq_gen",sequenceName = "roles_tb_seq", allocationSize = 1)
    private Long id;

    private String name;

    private boolean isActive;

}
