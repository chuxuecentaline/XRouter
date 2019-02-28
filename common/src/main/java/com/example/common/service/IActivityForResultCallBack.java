package com.example.common.service;

import android.content.Intent;

/**
 *用于界面的回调
 *
 * @Author: cherish
 * @CreateDate: 2019/2/28 16:18
 */

public interface IActivityForResultCallBack {
    void invoke(Intent intent, int requestCode);
}
