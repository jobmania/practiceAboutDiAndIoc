package com.hello.core._1_springbasicdi;

public class Member {
    Long Id;
    String name;

    public Member(Long id, String  name) {
        Id = id;
        this.name = name;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
