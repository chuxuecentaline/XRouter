package com.example.common.service;

import android.content.Context;

import java.util.Map;

/**
 * 登陆
 *
 * @Author: cherish
 * @CreateDate: 2019/2/28 10:45
 */

public interface ILoginService {
    void launcher(Context context, Map<String,Object> params);
    void launcherActivityForResult(Context context, Map<String,Object> params,int requestCode,IActivityForResultCallBack callBack);
}
