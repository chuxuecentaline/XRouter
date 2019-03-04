package com.example.router.butterknife;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;


/**
 * findViewById 工具类
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 21:06
 */

public class ViewUtils {
    public static <T extends View> T findViewById(Activity activity, int id) {
        return activity.findViewById(id);

    }
}
