package com.hello.core._3_practice;

import com.hello.core._3_practice.User;

public interface UserService {
    void save(User user);
    User find(Long userId);
}
