package com.hello.core._3_practice.service;

import com.hello.core._2_practice.user.User;
import com.hello.core._3_practice.annotation.Autowired;
import com.hello.core._3_practice.annotation.Component;
import com.hello.core._3_practice.repository.UserRepository;


@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId);
    }


}
