package com.example.common.base;


import android.app.Application;

import com.example.common.service.ServiceFactory;
import com.example.router.BuildConfig;
import com.example.router.XRouter;


/**
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 14:59
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ServiceFactory.init(this);
        XRouter.init(this);
        XRouter.openDebug(BuildConfig.DEBUG);

    }

}
