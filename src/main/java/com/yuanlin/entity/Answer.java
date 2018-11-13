package com.yuanlin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Question question;
    @OneToMany
    private List<Comment> comments=new LinkedList<>();
}
