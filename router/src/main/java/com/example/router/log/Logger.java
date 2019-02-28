package com.example.router.log;

import android.text.TextUtils;
import android.util.Log;

/**
 * lever 打印
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:44
 */

public class Logger implements ILogger {
    private String defaultTag = "XRouter";
    private boolean debugMode;

    @Override
    public void e(String tag, String message) {
        if (debugMode) {
            Log.e(TextUtils.isEmpty(tag) ? defaultTag : tag, message);
        }
    }

    @Override
    public void i(String tag, String message) {
        if (debugMode) {
            Log.i(TextUtils.isEmpty(tag) ? defaultTag : tag, message);
        }
    }

    @Override
    public void w(String tag, String message) {
        if (debugMode) {
            Log.w(TextUtils.isEmpty(tag) ? defaultTag : tag, message);
        }
    }

    @Override
    public void d(String tag, String message) {
        if (debugMode) {
            Log.d(TextUtils.isEmpty(tag) ? defaultTag : tag, message);
        }
    }

    public void IsOpen(boolean debugMode) {
        this.debugMode = debugMode;
    }
}
