package com.hello.core._3_practice;




import com.hello.core._3_practice.annotation.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class UserRepositoryImpl implements UserRepository {

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
