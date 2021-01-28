package com.sfac.springMvc.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: Method Info Annotation
 * @author HymanHu
 * @date 2021-01-28 14:41:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodInfoAnnotation {
}
