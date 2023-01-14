package com.hello.core._3_practice;


import com.hello.core._3_practice.User;

public interface UserRepository {
    void save(User user);

    User findById(Long userId);
}
