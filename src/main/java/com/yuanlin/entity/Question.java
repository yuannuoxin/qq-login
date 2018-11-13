package com.yuanlin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Answer> answers=new LinkedList<>();
}
