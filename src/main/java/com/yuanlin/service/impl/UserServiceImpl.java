package com.yuanlin.service.impl;

import com.yuanlin.entity.User;
import com.yuanlin.wrapper.EntityWrapper;
import com.yuanlin.repository.*;
import com.yuanlin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public EntityWrapper<User> login(String username, String password) {
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if(!existsByUsername(username)){
            wrapper.message="用户不存在";
            wrapper.setStatus(1);
            return wrapper;
        }
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user==null){
            wrapper.message="用户名或密码错误";
            wrapper.setStatus(1);
            return wrapper;
        }
        wrapper.setE(user);
        return wrapper;
    }

    @Override
    public EntityWrapper<User> register(String username, String password) {
        boolean exists = existsByUsername(username);
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if (exists) {
            wrapper.message="用户已经存在";
            wrapper.setStatus(1);
            return wrapper;
        }
        User user = new User(username, password);
        User save = userRepository.save(user);
        if (save==null){
            wrapper.message="注册失败，数据库错误";
            wrapper.setStatus(1);
            return wrapper;
        }
        wrapper.setE(save);
        return wrapper;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
