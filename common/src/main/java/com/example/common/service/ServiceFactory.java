package com.example.common.service;

import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 页面跳转服务
 *
 * @Author: cherish
 * @CreateDate: 2019/2/28 13:19
 * 能快速访问的Set，那么就要用HashSet,如果你要一个排序Set，那么你应该用TreeSet,如果你要记录下插入时的顺序时，你应该使用LinedHashSet
 */

public class ServiceFactory {
    private static volatile ServiceFactory ourInstance;
    private static  Context mContext;
    Set<Object> set = new HashSet();

    //将所有的服务对象封装到一个集合中
    public static ServiceFactory getInstance() {
        if (ourInstance == null) {
            synchronized (ServiceFactory.class) {
                if (ourInstance == null) {
                    ourInstance = new ServiceFactory();
                }

            }

        }
        return ourInstance;
    }

    public static  void init(Context context) {
        mContext = context;
    }

    private ServiceFactory() {
        if(mContext==null){
            throw new RuntimeException("请在application 中 先执行ServiceFactory.init(context)方法");
        }
    }



    public void setIiveService(IIiveService iiveService) {
        set.add(iiveService);
    }



    public void setLoginService(ILoginService loginService) {
        set.add(loginService);
    }

    public <T> T invoke(final Class<T> service) {

        return (T) Proxy.newProxyInstance(service.getClassLoader(), new  Class<?>[] {service}, new InvocationHandler() {


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object newInstance=null;
                for (Object impl : set) {
                    if(service.isAssignableFrom(impl.getClass())){
                        newInstance=impl;
                    }
                }
                if(newInstance==null){
                    Toast.makeText(mContext,service.getSimpleName()+"模块没有被加载进来",Toast.LENGTH_SHORT).show();
                   return null;
                }

                method.setAccessible(true);
                return method.invoke(newInstance,args);
            }
        });
    }
}
