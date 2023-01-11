package com.hello.core._2_practice.user;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDao implements UserDao {
    //구현 , 인메모리에 저장하는 것
    private static Map<Long, User> users = new HashMap<>();

    @Override
    public void insert(User user) {

    }

    @Override
    public User findById(long id) {
        return null;
    }
}
