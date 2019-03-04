package com.example.cherish.xrouter.util.alipay;

import android.app.Activity;

/**
 *
 * @Author: cherish
 * @CreateDate: 2019/3/4 14:54
 */

public class AliPayThread extends Thread  {

    public AliPayThread(Activity activity,String resoultString) {
        super(new AlipayTask(activity, resoultString, new AliPayHandler()));

    }


}
