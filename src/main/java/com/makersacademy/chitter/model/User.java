package com.makersacademy.chitter.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`User`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private  Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "passwordConfirm", nullable = false)
    private String passwordConfirm;

    private User() {}

    public User(String email, String passwordHash, String passwordConfirmHash) {
        this.email = email;
        this.password = passwordHash;
        this.passwordConfirm = passwordConfirmHash;
    }


}
