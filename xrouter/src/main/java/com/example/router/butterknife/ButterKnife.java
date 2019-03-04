package com.example.router.butterknife;

import android.app.Activity;

import java.lang.reflect.Constructor;

/**
 * 编译注解自动生成findViewById
 *
 * @Author: cherish
 * @CreateDate: 2019/2/27 13:09
 */

public class ButterKnife {

    private static UnBinder mUnBinder=UnBinder.EMPTY;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public final static void bind(Activity activity) {

        String viewBindingClassName = activity.getClass().getName()+ "_ViewBinding";

        //初始化对象  xxx_packageName_ViewBinding(this)
        try {
            Class<? extends UnBinder> viewBindingClass = (Class<? extends UnBinder>) Class.forName(viewBindingClassName);

            Constructor<? extends UnBinder> constructor = viewBindingClass
                    .getDeclaredConstructor(activity.getClass());
            mUnBinder = constructor.newInstance(activity);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void unbind() {
        mUnBinder.unbind();
    }
}
