package com.example.cookcode.cookcode.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    Long id;
    String username;
    String name;
    String email;
    String password;
    String image;
    String role;
    String phone;
    boolean enabled;
}
