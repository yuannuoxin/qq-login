package com.yuanlin.controller;

import com.yuanlin.entity.User;
import com.yuanlin.service.UserService;
import com.yuanlin.wrapper.EntityWrapper;
import com.yuanlin.wrapper.MessageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;

    @RequestMapping("/")
    public Object index() {
        return session.getAttribute("user");
    }

    @RequestMapping("/login")
    public Object login(@RequestParam String username, @RequestParam String password) {
        //1 如果用户已登录 则登录失败
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return new MessageWrapper(1, "用户已登录");
        }
        //2 用户名 和密码长度应该大于4位且小于16位
        if (username.length() < 4 || password.length() < 4 || username.length() > 16 || password.length() > 16) {
            return new MessageWrapper(1, "用户名 和密码长度应该大于4位且小于16位");
        }
        //3 查看数据库
        EntityWrapper<User> userWrapper = userService.login(username, password);
        //数据库信息比对失败
        if (userWrapper.getStatus() != 0) {
            return new MessageWrapper(1, userWrapper.getMessage());
        }
        //数据库信息比对成功 session 记录
        session.setAttribute("user", userWrapper.getE());
        return userWrapper;
    }

    @RequestMapping("/register")
    public Object register(@RequestParam String username, @RequestParam String password) {
        //1 如果用户已登录 则登录失败
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return new MessageWrapper(1, "用户已登录");
        }
        if (username.length() < 4 || password.length() < 4 || username.length() > 16 || password.length() > 16) {
            return new MessageWrapper(1, "用户名 和密码长度应该大于4位且小于16位");
        }
        EntityWrapper<User> register = userService.register(username, password);
        if (register.getStatus() != 0) {
            //注册 失败
            return new MessageWrapper(1, register.getMessage());
        }
        //注册 成功
        return new MessageWrapper(0, "注册成功");
    }
}
