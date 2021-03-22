package io.zbc.price.aop.annotation;

import io.zbc.price.entity.OperationObjectType;
import io.zbc.price.entity.OperationType;

import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 用户操作类型
     *
     * @return
     */
    @NotNull
    OperationType type();

    /**
     * 用户操作对象
     *
     * @return
     */
    @NotNull
    OperationObjectType objType();

}
