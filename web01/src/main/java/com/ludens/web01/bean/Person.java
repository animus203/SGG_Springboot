package com.ludens.web01.bean;

import java.util.Date;

public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

    public Person() {
    }

    public Person(String userName, Integer age, Date birth, Pet pet) {
        this.userName = userName;
        this.age = age;
        this.birth = birth;
        this.pet = pet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
