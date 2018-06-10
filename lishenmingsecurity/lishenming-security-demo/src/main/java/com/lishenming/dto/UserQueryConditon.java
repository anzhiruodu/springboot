package com.lishenming.dto;

/**
 * 这是控制前台传入的参数的对象
 */
public class UserQueryConditon {

    private String  username;
    private int age;
    private int ageTo;
    private int  xxx;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public void setXxx(int xxx) {
        this.xxx = xxx;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public int getXxx() {
        return xxx;
    }
}
