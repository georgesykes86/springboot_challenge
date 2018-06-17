package com.makersacademy.chitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "password")
@Entity
@Table(name = "`Users`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private  Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "passwordConfirm", nullable = true)
    private String passwordConfirm;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    @JsonIgnore
    private List<Peep> peeps = new ArrayList<>();

    public User() {}

    public User(String username, String passwordHash, String passwordConfirmHash) {
        this.username = username;
        this.password = passwordHash;
        this.passwordConfirm = passwordConfirmHash;
    }


}
