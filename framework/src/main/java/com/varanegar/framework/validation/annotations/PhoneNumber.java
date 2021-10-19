package com.varanegar.framework.validation.annotations;

import com.varanegar.framework.validation.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by A.Torabi on 8/24/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Validation(checkerClass = PhoneNumberChecker.class)
public @interface PhoneNumber {
    boolean isMandatory() default false;
}
