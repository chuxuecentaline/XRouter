package com.example.router;

import android.content.Context;

import java.util.Map;

/**
 *  回调
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 15:28
 */

public interface IRouterAction {
    RouterResult invokeAction(Context context, Map<String, Object> requestData);
}
