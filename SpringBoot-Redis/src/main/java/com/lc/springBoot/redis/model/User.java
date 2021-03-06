package com.lc.springBoot.redis.model;


/**
 * @author lengchuan <lishuijun1992@gmail.com>
 * @date 17-5-8
 */
public class User extends Entity {


    private static final long serialVersionUID = 3851693437814157257L;
    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
