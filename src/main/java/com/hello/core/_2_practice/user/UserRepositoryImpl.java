package com.hello.core._2_practice.user;

import com.hello.core._1_springbasicdi.Member;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{

    private static Map<Long, User> store = new HashMap<>();


    @Override
    public void save(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public User findById(Long userId) {
        return store.get(userId);
    }
}
