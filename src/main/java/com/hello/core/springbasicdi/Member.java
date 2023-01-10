package com.hello.core.springbasicdi;

public class Member {
    Long Id;
    Long name;

    public Member(Long id, Long name) {
        Id = id;
        this.name = name;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }
}
