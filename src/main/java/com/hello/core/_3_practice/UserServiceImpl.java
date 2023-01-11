package com.hello.core._3_practice;

import com.hello.core._2_practice.user.User;

@Inject
public class UserServiceImpl implements UserService{


   private final UserRepository userRepository;

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
