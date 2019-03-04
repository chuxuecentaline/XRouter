package com.hot.cherish.live.app;

import android.app.Application;

import com.example.common.base.BaseApplication;
import com.example.common.service.IApplication;
import com.example.common.service.ServiceFactory;
import com.hot.cherish.live.impl.liveServiceImpl;

/**
 *
 * @Author: cherish
 * @CreateDate: 2019/2/28 13:03
 */

public class LiveApp extends BaseApplication implements IApplication{
    private Application application;

    public Application getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initialzation(application);
    }

    @Override
    public void initialzation(Application application) {
        ServiceFactory.getInstance().addService(new liveServiceImpl());
    }
}
