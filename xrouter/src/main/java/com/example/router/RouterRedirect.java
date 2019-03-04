package com.example.router;

import android.content.Intent;


import com.example.router.exception.ErrorActionWrapper;
import com.example.router.interceptor.ActionInterceptor;

import java.util.List;
import java.util.Map;

/**
 * 路由的重定向
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:24
 */

public class RouterRedirect {

    public RouterRedirect(ErrorActionWrapper errorActionWrapper, List<ActionInterceptor> interceptors) {

    }

    public RouterRedirect param(String key, String value) {
        return this;
    }
    public RouterRedirect params(Map<String,Object> map) {
        return this;
    }

    public void invokeAction() {

    }


    public void invokeAction(ActionCallback callback) {

    }
}
