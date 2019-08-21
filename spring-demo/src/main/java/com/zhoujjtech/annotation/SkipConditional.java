package com.zhoujjtech.annotation;

import com.zhoujjtech.condition.SkipCondition;
import org.springframework.context.annotation.Conditional;

@Conditional(SkipCondition.class)
public @interface SkipConditional {
}
