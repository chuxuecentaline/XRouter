package com.example.router.interceptor;

/**
 * 拦截器 采用链式调用的方法 仿照 okHttp
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:59
 */

public interface ActionInterceptor {
    void intercept(Chain chain);

     interface Chain {
         //打断拦截
         void intercept();
         //分发给下一个拦截器
         void process(ActionPost actionPost);
         // 获取 ActionPost
         ActionPost action();

         String actionPath();
    }
}
