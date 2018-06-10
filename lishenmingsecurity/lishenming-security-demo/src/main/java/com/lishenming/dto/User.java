package com.lishenming.dto;


import com.fasterxml.jackson.annotation.JsonView;
import com.lishenming.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * jsonvew的使用场景：某些字段，在某些查询时不想展示出来，但是有些查询，又想展示出来
 * 使用步骤：1：定义借口
 *             2：在get方法上写上@jsonview的注解
 *                  3:在controller方法上指定@jsonView
 *
 *
 * hibernate.validator.的对字段的控制
 * 1：在字段上加 @NotBlank
 * 2:在方法的参数中加@valid
 * 3:参数中加入BindingResult参数，可以拿到所有的错误
 *
 *
 *
 */
public class User {


    public interface UserSimpleView{};
    public  interface UserDetailView extends UserSimpleView{};

    private int id;
    @MyConstraint(message = "这是一个测试")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String passWord;

    @Past(message = "生日不能是过去的时间")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getUserName() {
        return userName;
    }

    @JsonView(UserDetailView.class)
    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @JsonView(UserSimpleView.class)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
