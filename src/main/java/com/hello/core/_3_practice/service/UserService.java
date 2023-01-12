package com.hello.core._3_practice.service;

import com.hello.core._2_practice.user.User;

public interface UserService {
    void join(User user);
    User findById(Long userId);
}
