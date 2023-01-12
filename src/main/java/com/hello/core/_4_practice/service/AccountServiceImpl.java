package com.hello.core._4_practice.service;

import com.hello.core._4_practice.di_framework.annotation.Component;

@Component
public class AccountServiceImpl implements AccountService{
    @Override
    public Long getAccountNumber(String userName) {
        return 1L ;
    }
}
