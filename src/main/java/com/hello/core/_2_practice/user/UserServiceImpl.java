package com.hello.core._2_practice.user;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }



    @Override
    public User findById(Long userId){
        return userRepository.findById(userId);
    }

}
