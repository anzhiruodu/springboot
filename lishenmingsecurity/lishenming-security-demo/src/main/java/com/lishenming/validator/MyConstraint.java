package com.lishenming.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * validator校验器
 * constraint约束
 */
@Target({ElementType.METHOD,ElementType.FIELD})//指定注解可以标注在什么地方：方法。类，字段。。。
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)//java标准的校验,validatedBy需要什么类去校验，也就是校验逻辑在哪个类
public @interface MyConstraint {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
