package com.makersacademy.chitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.makersacademy.chitter.model.User;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "peep")
public class Peep {

    private @Id @GeneratedValue Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    private Peep() {}

    public Peep(String content, User user) {
        this.content = content;
        this.user = user;
    }

}
