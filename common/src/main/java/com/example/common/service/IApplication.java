package com.example.common.service;

import android.app.Application;

/**
 * 通过Application 入口设置module某个服务的 实例，在宿主activity 中之间通过该实列进行跳转
 *
 * @Author: cherish
 * @CreateDate: 2019/2/28 10:41
 */

public interface IApplication {
    void initialzation(Application application);
}
