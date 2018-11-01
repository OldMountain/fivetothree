package com.nxd.ftt.config.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * 日志、权限
 *
 * @author OldMountain
 * @date 2018/10/31
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
public @interface LogAndPermission {

    String[] permissions() default {};

    String operation() default "";

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "name"
    )
    String name() default "";

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "value"
    )
    String[] value() default {};

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "path"
    )
    String[] path() default {};

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "method"
    )
    RequestMethod[] method() default {};

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "params"
    )
    String[] params() default {};

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "headers"
    )
    String[] headers() default {};

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "consumes"
    )
    String[] consumes() default {};

    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "produces"
    )
    String[] produces() default {};
}
