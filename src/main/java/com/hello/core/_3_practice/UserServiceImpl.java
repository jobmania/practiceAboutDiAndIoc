package com.hello.core._3_practice;

import com.hello.core._3_practice.annotation.Autowired;
import com.hello.core._3_practice.annotation.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(Long userId) {
        return userRepository.findById(userId);
    }
}
