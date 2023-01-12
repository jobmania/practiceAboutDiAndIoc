package com.hello.core._4_practice.service;

import com.hello.core._4_practice.di_framework.annotation.Component;

@Component
public class UserServiceImpl implements UserService {


    @Override
    public String getUserName() {
        return "이름.";
    }
}
