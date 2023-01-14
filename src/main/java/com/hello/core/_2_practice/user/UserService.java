package com.hello.core._2_practice.user;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User findById(Long userId){
        return userRepository.findById(userId);
    }

}
