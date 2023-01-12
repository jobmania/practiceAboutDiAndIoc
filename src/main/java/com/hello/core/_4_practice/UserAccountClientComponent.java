package com.hello.core._4_practice;

import com.hello.core._4_practice.di_framework.annotation.Autowired;
import com.hello.core._4_practice.di_framework.annotation.Component;
import com.hello.core._4_practice.service.AccountService;
import com.hello.core._4_practice.service.UserService;

/**
 * Client class, have in userService and accountService expected to initialized by
 * CustomInjector.java
 */
@Component
public class UserAccountClientComponent {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public void displayUserAccount(){
        String username = userService.getUserName();
        Long accountNumber = accountService.getAccountNumber(username);
        System.out.println("\n\tUser Name: " + username + "\n\tAccount Number: " + accountNumber);
    }




}
