package com.hello.core.practice;

import java.util.HashMap;
import java.util.Map;

 interface UserDao {

     void insert(User user);

     User findById(long id);
}