package com.example.router.butterknife;

import android.support.annotation.UiThread;

/**
 * F解绑
 *
 * @Author: cherish
 * @CreateDate: 2019/2/27 13:12
 */

public interface UnBinder {
    @UiThread
    void unbind();
     UnBinder EMPTY=new UnBinder() {

        @Override
        public void unbind() {

        }
    };
}
