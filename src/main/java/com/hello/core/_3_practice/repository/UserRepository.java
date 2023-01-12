package com.hello.core._3_practice.repository;

import com.hello.core._1_springbasicdi.Member;
import com.hello.core._2_practice.user.User;

public interface UserRepository {
    void save(User user);

    User findById(Long userId);
}
