package com.yuanlin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions=new LinkedList<>();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers=new LinkedList<>();
    public boolean addQuestion(Question question){
        assert question == null ? false:true ;
        question.setUser(this);
        return true;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
