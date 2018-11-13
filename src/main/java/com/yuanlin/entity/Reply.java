package com.yuanlin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
//回复
public class Reply {
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    private String type;// 1. Reply, 2.Comment
    private Integer Reply_id;
    private Integer Comment_id;


}
