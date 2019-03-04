package com.example.cherish.xrouter.util.alipay;


import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 *
 *
 * @Author: cherish
 * @CreateDate: 2019/3/4 13:39
 */

public class AliPayHandler  extends Handler {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        System.out.println("==================="+msg.obj.toString());
    }
}
