package com.xrouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *点击事件
 *
 * @Author: cherish
 * @CreateDate: 2019/2/27 16:19
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@ListenerClass(
        targetType = "android.view.View",
        setter = "setOnClickListener",
        type = "butterknife.internal.DebouncingOnClickListener",
        method = @ListenerMethod(
                name = "doClick",
                parameters = "android.view.View"
        )
)
public @interface onClick {
    int[] value();
}
