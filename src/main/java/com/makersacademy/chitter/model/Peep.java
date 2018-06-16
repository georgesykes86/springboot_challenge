package com.makersacademy.chitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.makersacademy.chitter.model.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "peeps")
public class Peep {

    @Id
    @GeneratedValue
    private
    Long id;

    @Column(name="content")
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    private Peep() {}

    public Peep(String content) {
        this.content = content;
    }

}
