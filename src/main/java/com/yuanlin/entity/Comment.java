package com.yuanlin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    @ManyToOne
    private Answer answer;
}
