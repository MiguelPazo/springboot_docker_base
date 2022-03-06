package com.miguelpazo.auth.annotations;

import com.miguelpazo.auth.annotations.validators.EmailValidator;
import com.miguelpazo.auth.common.ConstMessages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default ConstMessages.EMAIL_BAD_FORMAT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

