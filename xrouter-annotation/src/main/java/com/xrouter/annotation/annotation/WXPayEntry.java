package com.xrouter.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 绕过微信支付和分享的局限
 *
 * @Author: cherish
 * @CreateDate: 2019/3/4 16:52
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface WXPayEntry {
    /**
     * 包名
     */
    String  packageName();

    /**
     * 类的Class
     * @return
     */
    Class<?> entryClass();
}
