package com.example.login.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.example.common.base.BaseApplication;

import com.example.common.service.IApplication;
import com.example.common.service.ServiceFactory;
import com.example.login.LoginActivity;
import com.example.login.impl.LoginServiceImpl;

import java.util.Map;

/**
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 17:18
 */

public class LoginApp extends BaseApplication implements IApplication {
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
        ServiceFactory.getInstance().addService(new LoginServiceImpl());
    }


}
