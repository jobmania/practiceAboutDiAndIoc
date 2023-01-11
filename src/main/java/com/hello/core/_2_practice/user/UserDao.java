package com.hello.core._2_practice.user;

public interface UserDao {
    // 역할
     void insert(User user);

     User findById(long id);
}