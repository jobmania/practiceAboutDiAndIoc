package com.hello.core._2_practice.user;

public class UserService {
    private final UserDao userDao;  // 이것은 구현이 아닌 역할에 의존..  만약 InMemoryUserDao에 의존한다면 그것은 역할에 의존한다는 것
                                    //   DIP = 구현체에 의존이 아닌 인터페이스에 의존해야한다.



    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User join(User user) {
        userDao.insert(user);
        return userDao.findById(user.getId());
    }
}
