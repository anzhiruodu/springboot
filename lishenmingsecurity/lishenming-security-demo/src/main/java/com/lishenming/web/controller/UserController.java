package com.lishenming.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lishenming.dto.FileInfo;
import com.lishenming.dto.User;
import com.lishenming.dto.UserQueryConditon;
import com.lishenming.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @RequestParam(required=false,name = "username")
     * @@RequestParam要求必须传一个参数 required参数是否必须, name = "username"指定传入的参数的名字
     * <p>
     * <p>
     * Pageable需要用spring提供的，，java也有这个类，
     * 这个是springdata提供的
     * @PageableDefault(page = 2,size = 17,sort = "username asc")前台没传，写默认的
     */

    @JsonView(User.UserSimpleView.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<User> query(UserQueryConditon userQueryConditon, @PageableDefault(page = 2, size = 17, sort = "username asc") Pageable pageable) {
        //反射工具 commons-lang-2.6.jar依赖 Reflection反射
        String str = ReflectionToStringBuilder.toString(userQueryConditon, ToStringStyle.MULTI_LINE_STYLE);
        System.out.println(str);
        System.out.println(pageable.getPageSize());
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @JsonView(User.UserDetailView.class)
    @GetMapping(value = "/{id:\\d+}")//  :\d+表示只能接受一个数字
    public User getInfo(@PathVariable String id) {
//        throw new UserNotExistException(id);

        User user = new User();
        user.setUserName("tom");
        System.out.println("service:::");
        return user;
    }

    /**
     * @RequestBody 这个注解才会解析传入的值（对象）post请求
     */
    @PostMapping()
    public User create(@Valid @RequestBody User user) {//, BindingResult errors
        System.out.println(user.getUserName() + user.getPassWord() + user.getId());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
//                FieldError fieldError = (FieldError) error;
//                String s = fieldError.getField() + "::" + error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user.getUserName() + user.getPassWord() + user.getId());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {

    }





}
