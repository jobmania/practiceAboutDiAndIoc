package com.hello.core._2_practice.user;

public interface UserRepository {
    void save(User user);
    User findById(Long userId);
}
