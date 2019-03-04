package com.example.router;


import android.content.Context;

import com.example.router.exception.ErrorActionWrapper;
import com.example.router.interceptor.ActionInterceptor;
import com.example.router.log.Logger;
import com.example.router.utils.Consts;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由实现
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:10
 */

public class XRouter {
    private static boolean debugMode = false;
    private static Context mContext;
    private static Logger mLogger=new Logger();
    private static List<ActionInterceptor> interceptors = new ArrayList<>();
    private XRouter() {
        mLogger = new Logger();
    }

    public static void openDebug(boolean debug) {
        debugMode = debug;
        mLogger.IsOpen(debugMode);
        mLogger.d(Consts.TAG, "DRouter openDebug");
    }

    public static XRouter getInstance() {
        return XRouterSingle.router;
    }

    public static  void init(Context context) {
        mContext = context;

    }

    public RouterRedirect action(String actionName) {
        //1.动态
        if (!actionName.contains("/")) {
            String message = "action name  format error -> <" + actionName + ">, like: " +
                    "moduleName/actionName";
            debugMessage(message);
            return new RouterRedirect(new ErrorActionWrapper(), interceptors);
        }

        return null;

    }

    private void debugMessage(String message) {
        mLogger.e(Consts.TAG,message);
    }

    private static class XRouterSingle {
        public volatile static XRouter router = new XRouter();
    }
}
