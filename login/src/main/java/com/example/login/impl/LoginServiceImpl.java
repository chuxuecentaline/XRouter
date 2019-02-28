package com.example.login.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Parcelable;

import com.example.common.base.BaseActivity;
import com.example.common.service.IActivityForResultCallBack;
import com.example.common.service.ILoginService;
import com.example.login.LoginActivity;

import java.io.Serializable;
import java.util.Map;

/**
 * 实现
 *
 * @Author: cherish
 * @CreateDate: 2019/2/28 10:52
 */

public class LoginServiceImpl implements ILoginService {
    @Override
    public void launcher(Context context, Map<String, Object> params) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (params!=null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                intent.putExtra(entry.getKey(), (Serializable) entry.getValue());
            }
        }
        context.startActivity(intent);

    }

    @Override
    public void launcherActivityForResult(Context context, Map<String, Object> params, int
            requestCode,IActivityForResultCallBack callBack) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (params!=null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                intent.putExtra(entry.getKey(), (Serializable) entry.getValue());
            }
        }
        callBack.invoke(intent, requestCode);
    }

}
