package com.duckchat.basecomponent.comn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 替代Activity的SetContentView
 */
@Target(ElementType.TYPE)//用于描述域
@Retention(RetentionPolicy.RUNTIME)//在运行时有效（即运行时保留)
public @interface ContentView {
    //id就是控件id，在某一个控件上使用注解标注其id
    int value() default -1;
}
