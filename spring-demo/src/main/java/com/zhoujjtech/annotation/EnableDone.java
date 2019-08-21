package com.zhoujjtech.annotation;

import com.zhoujjtech.imports.IndexImportBeanDefinitionRegistrar;
import com.zhoujjtech.imports.IndexImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(IndexImportSelector.class)
public @interface EnableDone {

    String value() default "";
}
