package com.example.cherish.xrouter;

import android.app.Application;

import com.example.common.base.BaseApplication;
import com.example.common.config.PackageConfig;
import com.example.common.service.IApplication;
import com.example.router.wechat.WXPayActivity;
import com.xrouter.annotation.annotation.WXPayEntry;

/**
 * @Author: cherish
 * @CreateDate: 2019/2/28 11:00
 */
@WXPayEntry(packageName = "com.example.cherish.xrouter",
        entryClass = WXPayActivity.class)
public class App extends BaseApplication implements IApplication {
    private Application application;
    //利用反射
    String[] packagenames = PackageConfig.PACKAGENAMES;
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

        for (int i = 0; i < packagenames.length; i++) {
            try {
                Class<?> aClass = Class.forName(packagenames[i]);
                Object newInstance = aClass.newInstance();//无参
                if(newInstance instanceof IApplication){
                    ((IApplication) newInstance).initialzation(application);

                }
               /* boolean impl =aClass.isAssignableFrom(IApplication.class);
                Method method = aClass.getDeclaredMethod("initialzation", application
                        .getClass());
                if(method!=null){
                    method.setAccessible(true);
                    method.invoke(newInstance,application);
                }*/

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("反射失败");
            }
        }

    }
}
