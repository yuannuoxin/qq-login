package com.yuanlin.service;

import com.yuanlin.entity.User;
import com.yuanlin.wrapper.EntityWrapper;

public interface UserService {
    public EntityWrapper<User> register(String username, String password);

    public boolean existsByUsername(String username);

    EntityWrapper<User> login(String username, String password);
}
