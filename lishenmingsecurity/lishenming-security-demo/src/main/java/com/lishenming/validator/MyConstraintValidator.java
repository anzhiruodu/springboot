package com.lishenming.validator;

import com.lishenming.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <MyConstraint,Object>
 * MyConstraint要验证的注解是什么
 * object表示可以标注在什么类型上如String
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println(":::"+value);
        return false;
    }
}
