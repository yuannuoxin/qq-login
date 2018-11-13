package com.yuanlin;

import com.yuanlin.entity.User;
import com.yuanlin.wrapper.EntityWrapper;
import com.yuanlin.repository.*;
import com.yuanlin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhihuApplicationTests {

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
    @Autowired
    UserService userService;
    @Test
    public void register() {
        System.out.println("=============================");
        EntityWrapper<User> test = userService.register("test", "test");
        if(test.e==null) System.out.println("e==null");
        System.out.println(test);
        EntityWrapper<User> test2 = userService.register("test2", "test2");
        if(test2.e==null) System.out.println("e==null");
        System.out.println(test2);
        System.out.println("=============================");
    }
    @Test
    public void existsByUsername() {
        System.out.println("=============================");
        boolean existsByUsername = userRepository.existsByUsername("yuanlin");
        System.out.println(existsByUsername);
        boolean existsByUsername2 = userRepository.existsByUsername("yuanlin2");
        System.out.println(existsByUsername2);
        System.out.println("=============================");

    }

}
