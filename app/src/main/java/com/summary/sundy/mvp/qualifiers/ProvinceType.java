package com.summary.sundy.mvp.qualifiers;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author todo
 * @desc
 * @date 2017/5/1
 */
@Qualifier // 限定符
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ProvinceType {
	String value() default "";
}
