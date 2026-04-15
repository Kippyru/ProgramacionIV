package com.kevin.tp6.handler;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UserValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueUser {
    String message() default "El username ya existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}